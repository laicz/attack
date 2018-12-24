package com.zhou.attack.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by zhoumb on 2018/12/19
 */
@Service
public class UserService implements InitializingBean, DisposableBean {

    public UserService() {
        System.out.println("---> Constructor <---");
    }

    @PostConstruct
    public void postConstructor() {
        System.out.println("---> post constructor <---");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("---> post destory <---");
    }

    public void initMethod() {
        System.out.println("---> init method <---");
    }

    public void destoryMethod() {
        System.out.println("---> destory method <---");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("---> after properties set <---");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("---> disposableBean destory <---");
    }
}
