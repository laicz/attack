package com.zhou.attack.event;

import com.zhou.attack.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhoumb on 2018/12/20
 */
public class DemoEventListenerTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoService.class, DemoListener1.class, DemoListener2.class, Demo2Listener1.class, Demo2Listener2.class);
        applicationContext.getBean(DemoListener1.class);
        applicationContext.getBean(DemoListener2.class);
        applicationContext.getBean(Demo2Listener1.class);
        applicationContext.getBean(Demo2Listener2.class);
        DemoService bean = applicationContext.getBean(DemoService.class);
        bean.handle("消息1");
        bean.handle("消息2");


        bean.handle("-----消息1");
        bean.handle("-----消息2");
    }
}
