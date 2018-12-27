package com.zhou.attack.netty.im_011;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.zhou.attack.netty.im_008.protocol.request.LoginRequestPacket;
import com.zhou.attack.netty.im_008.protocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;
import java.util.UUID;

/**
 * Created by zhoumb on 2018/12/27
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        String userId = randomUserId();
        loginResponsePacket.setUserId(userId);
        SessionUtils.bindSession(new Session(userId, msg.getUsername()), ctx.channel());
    }

    private String randomUserId() {
        return UUID.randomUUID().toString();
    }
}
