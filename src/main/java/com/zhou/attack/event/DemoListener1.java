package com.zhou.attack.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 继承自ApplicationListener
 * 监听的事件不一样  则
 * Created by zhoumb on 2018/12/20
 */
@Component
public class DemoListener1 implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("demoListener1 接收到了 demoPublisher 发布的消息：" + msg);
    }
}
