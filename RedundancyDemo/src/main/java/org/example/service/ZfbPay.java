package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author tchstart
 * @data 2024-04-10
 */
@Slf4j
@Component
public class ZfbPay implements IPay{
    @Override
    public boolean supports(String code) {
        return "zfb".equals(code);
    }

    @Override
    public void pay() {
      log.info("使用支付宝方式支付");
    }
}
