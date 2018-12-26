package com.zhou.attack.netty.im_006;

import com.zhou.attack.netty.im_007.LoginUtil;
import com.zhou.attack.netty.im_007.MessageResponsePacket;
import com.zhou.attack.utils.DateFormateUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zhoumb on 2018/12/26
 */
public class LoginClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(DateFormateUtils.format(new Date(), DateFormateUtils.FormatTemplate.YMDHMS) + ": 客户端开始登陆");

        //创建登陆对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("zhou");
        loginRequestPacket.setPassword("pwd");

        //编码
        ByteBuf buffer = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginRequestPacket);
        //写数据
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
            if (loginResponsePacket.isSuccess()) {
                System.out.println(DateFormateUtils.format(new Date(), DateFormateUtils.FormatTemplate.YMDHMS) + " : 客户端登陆成功");
                LoginUtil.markAsLogin(ctx.channel());
            } else {
                System.out.println(DateFormateUtils.format(new Date(), DateFormateUtils.FormatTemplate.YMDHMS) + " : 客户端登陆失败 原因：" + loginResponsePacket.getReason());
            }
        } else if (packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) msg;
            System.out.println(DateFormateUtils.format(new Date(), DateFormateUtils.FormatTemplate.YMDHMS) + " : 接收到服务端的信息 : " + messageResponsePacket.getMessage());
        }
    }
}
