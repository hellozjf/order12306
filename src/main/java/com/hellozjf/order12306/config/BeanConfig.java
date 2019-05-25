package com.hellozjf.order12306.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hellozjf
 */
@Configuration
@Slf4j
public class BeanConfig {

    /**
     * 构建一个ObjectMapper，用于解析json
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
