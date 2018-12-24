package com.zhou.attack;

import com.zhou.attack.socket.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AttackApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AttackApplication.class, args);
        new NettyServer(8090).start();
    }
}

