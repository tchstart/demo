package com.tchstart.config;

import com.tchstart.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author tchstart
 * @data 2024-03-27
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.tchstart.annotation.Log)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        // 获取被增强的方法对象
        Method method = methodSignature.getMethod();
        if (method != null) {
            Log annotation = method.getAnnotation(Log.class);
            System.out.println(annotation.value());
        }

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        // 访问的url
        String url = request.getRequestURL().toString();
        // 请求方式
        String methodName = request.getMethod();
        System.out.println(methodName);
        // 登录IP
        String ipAddress = request.getRemoteAddr();
        System.out.println(ipAddress);
        // 操作时间
        System.out.println(new Date());
        // 保存数据库
        return null;
    }

}
