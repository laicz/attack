package com.zhou.attack.netty.im_002;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;

/**
 * Created by zhoumb on 2018/12/24
 */
public class IOClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8000));
        while (true) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((new Date() + " : " + "hello world").getBytes());
            Thread.sleep(2000);
        }
    }
}
