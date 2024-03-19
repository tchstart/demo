package com.tchstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author tchstart
 * @data 2024-03-19
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Slf4j
@EnableAsync
public class publishSubscribeApplication {

    public static void main(String[] args) {
        SpringApplication.run(publishSubscribeApplication.class, args);
        log.info("Application start success!");
    }



}