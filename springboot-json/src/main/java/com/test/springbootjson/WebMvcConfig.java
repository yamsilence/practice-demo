package com.test.springbootjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

// 全局处理日期格式化问题
@Configuration
public class WebMvcConfig {
    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper obm = new ObjectMapper();
        obm.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return obm;
    }
}
