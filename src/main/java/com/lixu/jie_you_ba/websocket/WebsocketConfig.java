package com.lixu.jie_you_ba.websocket;

import com.lixu.jie_you_ba.service.CommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Classname WebsocketConfig
 * @Description TODO
 * @Date 2019-05-05 16:33
 * @Created by lixu
 */
@Configuration
public class WebsocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 因 SpringBoot WebSocket 对每个客户端连接都会创建一个 WebSocketServer（@ServerEndpoint 注解对应的） 对象，Bean 注入操作会被直接略过，因而手动注入一个全局变量
     *
     * @param communicateService
     */
    @Autowired
    public void setMessageService(CommunicateService communicateService) {
        WebSocketServer. communicateService = communicateService;
    }
}
