package com.tchstart.listener;

import com.tchstart.event.SaveOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderNotifyListener {

    @EventListener
    @Async("asyncExecutor")
    public void notify(SaveOrderEvent event) {
        log.info("[afterSaveOrder] notify.");
    }
}