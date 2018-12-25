package com.zhou.attack.netty.im_003;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * Created by zhoumb on 2018/12/25
 */
public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boss, worker)
                //指定IO类型
                .channel(NioServerSocketChannel.class)
                //用来定义服务启动过程中的逻辑处理
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel ch) throws Exception {

                    }
                })
                //childHandler 定义后续每条连接的数据读写
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {

                    }
                })
                //自定义一些属性，可以通过channel.attr()来进行获取
                .attr(AttributeKey.newInstance("serverName"), "nettyServer")
                //标识开启TCP底层心跳机制，true为开启
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //标识开启Nagle算法，true标识关闭，false标识开启
                .childOption(ChannelOption.TCP_NODELAY, true)
        ;

    }

    //端口递增+1 直到绑定成功
    public static void bind(final ServerBootstrap serverBootstrap, int port) {
        //使用观察者模式  进行连接成功失败后的逻辑处理
        serverBootstrap.bind(8000).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("端口绑定成功");
                } else {
                    System.out.println("端口绑定失败");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }
}
