package com.zhou.attack.socket.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * web socket 设置类
 * Created by zhoumb on 2018/12/20
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //设置浏览器接收的服务前缀 同时也是后台服务推送的前缀
        registry.enableSimpleBroker("/topic");
        //设置浏览器发送消息的服务前缀，也是后台服务接收前台信息的前缀
        registry.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 添加服务断点  浏览器链接这个地址
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/my-websocket").withSockJS();
    }
}
