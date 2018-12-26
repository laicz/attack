package com.zhou.attack.netty.im_006;

/**
 * Created by zhoumb on 2018/12/26
 */
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String resson;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResson() {
        return resson;
    }

    public void setResson(String resson) {
        this.resson = resson;
    }

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
