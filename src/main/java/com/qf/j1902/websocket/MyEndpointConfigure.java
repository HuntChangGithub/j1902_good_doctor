package com.qf.j1902.websocket;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.websocket.server.ServerEndpointConfig;

/**
 *Endpoint 是用户订阅主题时，指定接收消息的终端地址
 * 当有消息发布到主题时，MNS 会主动将消息推送到对应的 Endpoint
 * Created by asus on 2019/7/22.
 */

public class MyEndpointConfigure extends ServerEndpointConfig.Configurator implements ApplicationContextAware {

    private static volatile BeanFactory context;

    @Override
    public <T> T getEndpointInstance(Class<T> clazz){
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyEndpointConfigure.context = applicationContext;

    }
}
