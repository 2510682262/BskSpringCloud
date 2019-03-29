package com.li.bsk.pay.service;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.pay.entity.AlipayOrder;

public interface AlipayService {

    // 创建订单
    ResultVo savePay(AlipayOrder alipayOrder);

    // 查询支付结果
    ResultVo queryPay(String trandon);

    // 下载对账单
    ResultVo queryBill(String date);
}
