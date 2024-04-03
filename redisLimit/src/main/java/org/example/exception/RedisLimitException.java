package org.example.exception;

/**
 * @author tchstart
 * @data 2024-04-03
 */
public class RedisLimitException extends RuntimeException{
    public RedisLimitException(String msg) {
        super( msg );
    }
}
