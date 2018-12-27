package com.zhou.attack.netty.im_008.codec;

import com.zhou.attack.netty.im_006.Packet;
import com.zhou.attack.netty.im_008.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by zhoumb on 2018/12/27
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(out, msg);
    }
}
