package com.worksphere.worksphere.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AppMessage appMessage(){
        return new AppMessage();
    }
}
