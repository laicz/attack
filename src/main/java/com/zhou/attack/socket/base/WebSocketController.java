package com.zhou.attack.socket.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhoumb on 2018/12/20
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping(value = "/")
    public String index() {
        return "test01";
    }

    // 测试页面显示后台消息推送的次数
    private int count = 0;

    @MessageMapping("/send")
    @SendTo("/topic/send")
    public SocketMessage send(SocketMessage message) {
        message.setMessage("浏览器消息");
        message.setDate(SIMPLE_DATE_FORMAT.format(new Date()));
        return message;
    }

    @SendTo("/topic/callback")
    @Scheduled(cron = "0/5 * * * * ?")
    public Object callback() {
        System.out.println("推送了消息" + SIMPLE_DATE_FORMAT.format(new Date()));
        messagingTemplate.convertAndSend("/topic/callback", "客户端消息" + count);
        count++;
        return null;
    }


}
