package org.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@Slf4j
public class RedundancyDemo {
    public static void main(String[] args) {
        SpringApplication.run(RedundancyDemo.class, args);
        log.info("Application start success!");
    }
}