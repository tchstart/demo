package com.tchstart.controller;

import com.tchstart.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tchstart
 * @data 2024-03-19
 */
@Slf4j
@RestController
public class ApiController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/pay/{orderSn}")
    public String alipay(@PathVariable("orderSn") String orderSn) {
        log.info("start...");
        String result = orderService.alipay(orderSn);
        log.info("end...！",result);
        return result;
    }

    @GetMapping(value = "/insert")
    public String insert() throws InterruptedException {
        log.info("start...");
        orderService.insert();
        log.info("end...");
        return "ok";
    }

}
