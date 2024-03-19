package com.tchstart.service;

import com.tchstart.entity.SaveOrderEventMessage;
import com.tchstart.event.SaveOrderEvent;
import com.tchstart.vo.OrderReqVO;
import com.tchstart.vo.OrderResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * SpringBoot项目实现发布订阅模式，真的很简单！
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 下单
     */
    @Override
    public OrderResVO saveOrder(OrderReqVO reqVO) {
        log.info("[placeOrder] start.");
        OrderResVO resVO = new OrderResVO();
        //消息
        SaveOrderEventMessage eventMessage = new SaveOrderEventMessage();
        //发布事件
        applicationEventPublisher.publishEvent(new SaveOrderEvent(eventMessage));
        log.info("[placeOrder] end.");
        return resVO;
    }
}