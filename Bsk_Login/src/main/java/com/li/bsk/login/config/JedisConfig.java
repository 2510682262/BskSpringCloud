package com.li.bsk.login.config;

import com.li.bsk.common.sysconst.SystemConst;
import com.li.bsk.common.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/3/19 14:42
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisUtil createJ(){
        return new JedisUtil(SystemConst.REDISHOST,SystemConst.REDISPORT,SystemConst.REDISPASS);
    }
}
