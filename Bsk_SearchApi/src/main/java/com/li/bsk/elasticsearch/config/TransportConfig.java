package com.li.bsk.elasticsearch.config;

import com.li.bsk.elasticsearch.transport.TransportBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransportConfig {
    @Bean
    public TransportBean createTB(){
        return new TransportBean ("qfjava","39.105.189.141",9300);
    }
}
