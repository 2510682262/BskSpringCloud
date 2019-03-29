package com.li.bsk.provider.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.li.bsk.mapper")
public class ProviderGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run (ProviderGoodsApplication.class,args);
    }
}
