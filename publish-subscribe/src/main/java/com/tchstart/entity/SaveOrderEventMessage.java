package com.tchstart.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SaveOrderEventMessage implements Serializable {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 下单用户ID
     */
    private String userId;
}