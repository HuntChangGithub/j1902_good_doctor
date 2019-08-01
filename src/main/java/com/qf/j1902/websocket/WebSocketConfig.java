package com.qf.j1902.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket配置
 * Created by asus on 2019/7/22.
 */

@Configuration
public class WebSocketConfig {
    /**
     * 扫描并注册所有携带@ServerEndpoint注解的实例
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 支持注入其他类
     */
    @Bean
    public MyEndpointConfigure  newMyEndpointConfigure (){
        return new MyEndpointConfigure ();
    }
}
