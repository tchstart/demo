package com.tchstart.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 记录日志信息
     * @return
     */
    String value() default "";
}
