package com.zhou.attack.netty.im_006;

/**
 * Created by zhoumb on 2018/12/26
 */
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;

    public LoginResponsePacket(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }

    public LoginResponsePacket(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
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
        return Command.LOGIN_RESPONSE;
    }
}
