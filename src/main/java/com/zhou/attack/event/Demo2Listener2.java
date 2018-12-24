package com.zhou.attack.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhoumb on 2018/12/20
 */
@Component
public class Demo2Listener2 implements ApplicationListener<Demo2Event> {
    @Override
    public void onApplicationEvent(Demo2Event event) {
        String msg = event.getMsg();
        System.out.println("demo2Listener1 获取到数据 : " + msg);
    }
}
