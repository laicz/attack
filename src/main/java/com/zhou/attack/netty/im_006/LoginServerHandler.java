package com.zhou.attack.netty.im_006;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhoumb on 2018/12/26
 */
public class LoginServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        //解码
        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        //判断是否是登陆请求数据包
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;


            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            //登录校验
            if (valid(loginRequestPacket)) {
                //校验成功
                loginResponsePacket.setSuccess(true);
            } else {
                //校验失败
                loginResponsePacket.setSuccess(false);
                loginResponsePacket.setResson("密码校验失败");
            }
            ByteBuf response = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(response);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return StringUtils.equals(loginRequestPacket.getUsername(),"zhou") && StringUtils.equals(loginRequestPacket.getPassword(),"pwd");
    }
}
