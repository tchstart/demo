package org.example.service;

/**
 * @author tchstart
 * @data 2024-04-10
 */
public interface IPay {

    boolean supports(String code);
    void pay();
}