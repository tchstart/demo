package org.example.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tchstart
 * @data 2024-04-10
 */
@Service
public class PayService implements InitializingBean, ApplicationContextAware{

    List<IPay> payList = new ArrayList<>();

    ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet(){
        Map<String, IPay> beansOfType = applicationContext.getBeansOfType(IPay.class);
        beansOfType.forEach((k,v) -> payList.add(v));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void pay(String code){
        for (IPay pay : payList) {
            if(pay.supports(code)){
                pay.pay();
            }
        }
    }


}
