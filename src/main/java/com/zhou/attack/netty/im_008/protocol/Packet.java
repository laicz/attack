package com.zhou.attack.netty.im_008.protocol;

/**
 * Created by zhoumb on 2018/12/27
 */
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version;

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public abstract Byte getCommand();
}
