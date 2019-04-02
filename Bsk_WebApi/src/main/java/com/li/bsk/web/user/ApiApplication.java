package com.li.bsk.web.user;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableSwagger2
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run (ApiApplication.class,args);
    }
}
