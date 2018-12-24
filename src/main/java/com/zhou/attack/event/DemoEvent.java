package com.zhou.attack.event;

import org.springframework.context.ApplicationEvent;

/**
 * 使用Spring事件及监听机制
 * Created by zhoumb on 2018/12/20
 */
public class DemoEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source) {
        super(source);
    }

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    private String msg;

    public void sysLog() {
        System.out.println(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
