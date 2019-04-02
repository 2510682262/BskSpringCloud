package com.li.bsk.web.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
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
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory ();
        simpleClientHttpRequestFactory.setConnectTimeout (60000);
        simpleClientHttpRequestFactory.setReadTimeout (60000);

        return new RestTemplate(simpleClientHttpRequestFactory);
    }

}
