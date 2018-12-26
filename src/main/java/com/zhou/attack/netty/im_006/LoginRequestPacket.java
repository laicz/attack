package com.zhou.attack.netty.im_006;

/**
 * 登陆请求数据包
 * Created by zhoumb on 2018/12/25
 */
public class LoginRequestPacket extends Packet {
    private String userId;
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
