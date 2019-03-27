package com.li.bsk.web.goods.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *@Author li
 *@Date Created in 2019/3/25 15:47
 */
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    public RestTemplate creteRT(){
        return new RestTemplate();
    }

}
