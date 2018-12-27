package com.zhou.attack.netty.im_008.protocol.request;

import com.zhou.attack.netty.im_008.protocol.Packet;

import static com.zhou.attack.netty.im_008.protocol.Command.LOGIN_REQUEST;

/**
 * Created by zhoumb on 2018/12/27
 */
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
