package com.zhou.attack.netty.im_007;

import com.zhou.attack.netty.im_006.Command;
import com.zhou.attack.netty.im_006.Packet;

/**
 * Created by zhoumb on 2018/12/26
 */
public class MessageRequestPacket extends Packet {

    private String message;

    public MessageRequestPacket(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
