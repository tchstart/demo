package org.example.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.exception.RedisLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tchstart
 * @data 2024-04-03
 */
@Slf4j
@Aspect
@Component
public class RedisLimitAop {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Pointcut("@annotation(org.example.annotation.RedisLimit)")
    private void check() {

    }

    private DefaultRedisScript<Long> redisScript;

    @PostConstruct
    public void init() {
        redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("rateLimiter.lua")));
    }


    @Before("check()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //拿到RedisLimit注解，如果存在则说明需要限流
        RedisLimit redisLimit = method.getAnnotation(RedisLimit.class);

        if (redisLimit != null) {
            //获取redis的key
            String key = redisLimit.key();
            String className = method.getDeclaringClass().getName();
            String name = method.getName();

            String limitKey = key + className + method.getName();

            log.info(limitKey);

            if (StringUtils.isEmpty(key)) {
                throw new RedisLimitException("key cannot be null");
            }

            long limit = redisLimit.permitsPerSecond();

            long expire = redisLimit.expire();

            List<String> keys = new ArrayList<>();
            keys.add(key);

            Long count = stringRedisTemplate.execute(redisScript, keys, String.valueOf(limit), String.valueOf(expire));

            log.info("Access try count is {} for key={}", count, key);

            if (count != null && count == 0) {
                log.debug("获取key失败，key为{}", key);
                throw new RedisLimitException(redisLimit.msg());
            }
        }

    }
}