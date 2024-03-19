package com.tchstart.service;

import com.tchstart.vo.OrderReqVO;
import com.tchstart.vo.OrderResVO;

public interface OrderService {

    public OrderResVO saveOrder(OrderReqVO reqVO);
}