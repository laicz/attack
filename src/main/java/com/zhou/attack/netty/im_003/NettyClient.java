package com.zhou.attack.netty.im_003;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhoumb on 2018/12/25
 */
public class NettyClient {
    public static void main(String[] args) {
        NioEventLoopGroup worker = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {

                    }
                });
        connect(bootstrap, "juejin.im", 80, MAX_RETRY);
    }

    //失败重连方法
    private static final int MAX_RETRY = 5;

    /**
     * 指定失败重连的的次数
     * 每次失败重连的间隔时间是上次的2倍
     * 定时任务调用：
     * bootstrap.config()返回的是BootstrapConfig,这是对Bootstrap配置参数的抽象
     *
     * @param bootstrap
     * @param host
     * @param port
     * @param retry
     */
    public static void connect(final Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("连接成功");
                } else if (retry == 0) {
                    System.out.println("重试次数已用完，连接失败");
                } else {
                    System.out.println("连接失败，将发起重试");
//                    connect(bootstrap, host, port, retry - 1);
                    int order = (MAX_RETRY - retry) + 1;
                    int delay = 1 << order;
                    bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
                }
            }
        });
    }
}
