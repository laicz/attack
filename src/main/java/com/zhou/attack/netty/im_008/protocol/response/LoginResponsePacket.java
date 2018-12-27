package com.zhou.attack.netty.im_008.protocol.response;

import com.zhou.attack.netty.im_008.protocol.Packet;

import static com.zhou.attack.netty.im_008.protocol.Command.LOGIN_RESPONSE;

/**
 * Created by zhoumb on 2018/12/27
 */
public class LoginResponsePacket extends Packet {
    private String userId;
    private Boolean success;

    private String reason;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
