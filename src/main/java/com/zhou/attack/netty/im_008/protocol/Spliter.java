package com.zhou.attack.netty.im_008.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 是否等于定义的魔数 做一个快速判断
 * <p>
 * 1.拆包器的作用就是根据我们的自定义协议，把数据拼装成一个个符合我们自定义数据包大小的 ByteBuf，然后送到我们的自定义协议解码器去解码。
 * 2.Netty 自带的拆包器包括基于固定长度的拆包器，基于换行符和自定义分隔符的拆包器，还有另外一种最重要的基于长度域的拆包器。通常 Netty 自带的拆包器已完全满足我们的需求，无需重复造轮子。
 * 3.基于 Netty 自带的拆包器，我们可以在拆包之前判断当前连上来的客户端是否是支持自定义协议的客户端，如果不支持，可尽早关闭，节省资源。
 * Created by zhoumb on 2018/12/27
 */
public class Spliter extends LengthFieldBasedFrameDecoder {
    private static final int LENGTH_FIELD_OFFSET = 7;
    private static final int LENGTH_FIELD_LENGTH = 4;

    public Spliter() {
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        //屏蔽非本协议的客户端
        if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
            ctx.channel().close();
            return null;
        }
        return super.decode(ctx, in);
    }
}
