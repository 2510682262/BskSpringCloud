package com.li.bsk.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.li.bsk.mapper")
@EnableSwagger2
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run (LoginApplication.class,args);
    }
}