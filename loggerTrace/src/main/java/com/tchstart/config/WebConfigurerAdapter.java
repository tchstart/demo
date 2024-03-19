package com.tchstart.config;

import com.tchstart.intecepter.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tchstart
 * @data 2024-03-19
 */
@Configuration
public class WebConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor loggingInterceptor() {
        return new LogInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor()).addPathPatterns("/**");
    }
}
