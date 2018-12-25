package com.zhou.attack.netty.im_002;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用IO编程的缺陷
 * 1，线程资源受限，线程是操作系统的非常宝贵的资源，同一时刻有大量的线程处于阻塞状态是非常严重的资源浪费
 * 2，线程切换效率低下，当CPU核数固定，线程爆炸后操作系统频繁进行线程切换，应用性能急剧下降
 * 3，数据读写时使用是以字节流为单位
 * <p>
 * IO读写是面向流的，一次性只能从流中读取一个或者多个字节，需要自己缓存数据，而NIO是面向Buffer的
 * 你可以随意读取里面任何一个字节数据，不需要自己缓存数据，只需要移动指针就可以完成这些操作
 * Created by zhoumb on 2018/12/24
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8000));
        while (true) {
            Socket accept = serverSocket.accept();
            //接收到新的连接连接请求，则创建新的线程来处理
            new Thread(() -> {
                try {
                    InputStream inputStream = accept.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = inputStream.read(bytes)) != -1) {
                        System.out.println(Thread.currentThread().getName() + "   ->    " + new String(bytes, 0, len));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
