package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.annotation.RedisLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tchstart
 * @data 2024-04-03
 */
@Slf4j
@RestController
@RequestMapping("/redis/limit")
public class LimitRedisController {

    /**
     * 基于Redis AOP限流
     */
    @GetMapping("/test")
    @RedisLimit(key = "redis-limit:test", permitsPerSecond = 2, expire = 10, msg = "当前排队人数较多，请稍后再试！")
    public String test() {
        log.info("限流成功。。。");
        return "ok";
    }

}
