package com.tchstart.controller;

import com.tchstart.service.OrderService;
import com.tchstart.vo.OrderReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tchstart
 * @data 2024-03-19
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public void placeOrder() {
        OrderReqVO orderReqVO = new OrderReqVO();
        orderService.saveOrder(orderReqVO);
    }
}
