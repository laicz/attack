package com.zhou.attack.netty.im_008.protocol;

/**
 * Created by zhoumb on 2018/12/27
 */
public interface Command {
    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}
