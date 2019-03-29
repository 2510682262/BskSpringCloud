package com.li.bsk.pay.service;

import com.li.bsk.common.vo.ResultVo;

import java.util.Map;

public interface WxPayService {

    // 生成订单
    ResultVo createPre(Map<String,String> map);

    // 查询订单
    ResultVo searchOrder(String orderId);

    // 查询对账单
    ResultVo searchBill(String billDate);
}
