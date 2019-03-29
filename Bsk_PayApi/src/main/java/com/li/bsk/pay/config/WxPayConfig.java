package com.li.bsk.pay.config;

import com.li.bsk.pay.util.WxPayUtil;
import com.li.bsk.pay.wechatpay.WXPayConstants;
import com.li.bsk.pay.wechatpay.WXPayUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxPayConfig {

    @Bean
    public WxPayUtil createWxPayUtil(){
        return new WxPayUtil(WXPayConstants.APP_ID, WXPayConstants.MCH_ID,WXPayConstants.API_KEY,WXPayConstants.HMACSHA256);
    }
}
