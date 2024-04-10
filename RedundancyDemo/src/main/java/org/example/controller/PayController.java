package org.example.controller;

import org.example.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tchstart
 * @data 2024-04-10
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;


    @GetMapping("pay")
    public void pay(@RequestParam String code){
        payService.pay(code);
    }
}
