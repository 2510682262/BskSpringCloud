package com.li.bsk.provider.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.li.bsk.mapper")
public class ProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run (ProviderUserApplication.class,args);
    }
}
