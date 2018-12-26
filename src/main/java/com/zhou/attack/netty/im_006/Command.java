package com.zhou.attack.netty.im_006;

/**
 * Created by zhoumb on 2018/12/25
 */
public interface Command {
    //登陆请求数据包
    Byte LOGIN_REQUEST = 1;

    //登陆回应数据包
    Byte LOGIN_RESPONSE = 2;
}
