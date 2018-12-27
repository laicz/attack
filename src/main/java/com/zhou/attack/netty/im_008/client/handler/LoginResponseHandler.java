package com.zhou.attack.netty.im_008.client.handler;

import com.zhou.attack.netty.im_008.protocol.request.LoginRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by zhoumb on 2018/12/27
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {

    }
}
