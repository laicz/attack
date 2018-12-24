package com.zhou.attack.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 继承自ApplicationListener
 * Created by zhoumb on 2018/12/20
 */
@Component
public class DemoListener2 implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("demoListener2 接收到了 demoPublisher 发布的消息：" + msg);
    }
}
