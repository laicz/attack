package com.zhou.attack.bean;

import com.zhou.attack.event.DemoListener1;
import com.zhou.attack.event.DemoListener2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhoumb on 2018/12/19
 */
public class UserServiceTest {

    @Bean(initMethod = "initMethod", destroyMethod = "destoryMethod")
    public UserService getUserService() {
        return new UserService();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //先初始化两个时间监听
        context.register(UserServiceTest.class);
        context.refresh();
        context.registerShutdownHook();
    }
}
