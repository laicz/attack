package com.zhou.attack.service;

import com.zhou.attack.event.Demo2Event;
import com.zhou.attack.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by zhoumb on 2018/12/20
 */
@Service
public class DemoService {
    @Autowired
    private ApplicationContext applicationContext;

    public void handle(String msg) {
        DemoEvent event = new DemoEvent(this, msg);
        System.out.println("demo service handle msg : " + msg + " , application class :" + applicationContext.getClass().getName());
        applicationContext.publishEvent(event);
    }

    public void handle2(String msg) {
        Demo2Event event = new Demo2Event(this, msg);
        System.out.println("demo2 service handle msg : " + msg + " , application class :" + applicationContext.getClass().getName());
        applicationContext.publishEvent(event);
    }
}
