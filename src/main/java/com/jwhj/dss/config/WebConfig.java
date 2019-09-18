package com.jwhj.dss.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 uri에 대해 http://localhost:18080, http://localhost:8180 도메인은 접근을 허용한다.
        registry.addMapping("/**")
                .allowedOrigins("https://frontenddssreact.firebaseapp.com","https://frontenddssreact.web.app/","http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com","http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com");

    }
}
