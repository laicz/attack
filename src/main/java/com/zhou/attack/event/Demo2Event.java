package com.zhou.attack.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by zhoumb on 2018/12/20
 */
public class Demo2Event extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public Demo2Event(Object source) {
        super(source);
    }

    public Demo2Event(Object source, String msg) {
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
