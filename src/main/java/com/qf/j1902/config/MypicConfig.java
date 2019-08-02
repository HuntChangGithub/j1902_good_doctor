package com.qf.j1902.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by asus on 2019/8/2.
 */
@Configuration
public class MypicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/userimg/**").addResourceLocations("file:src/main/resources/static/userimg/");
    }
}
