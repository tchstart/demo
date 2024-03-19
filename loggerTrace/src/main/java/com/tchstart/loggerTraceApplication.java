package com.tchstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author tchstart
 * @data 2024-03-19
 */
@EnableAsync
@SpringBootApplication
public class loggerTraceApplication {
    public static void main(String[] args) {
        SpringApplication.run(loggerTraceApplication.class, args);
    }
}