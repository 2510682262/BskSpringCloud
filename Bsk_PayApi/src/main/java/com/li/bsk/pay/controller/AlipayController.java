package com.li.bsk.pay.controller;

import com.alipay.api.AlipayObject;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.pay.entity.AlipayOrder;
import com.li.bsk.pay.service.AlipayService;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(value = "支付宝支付")
@RestController
public class AlipayController {

    @Autowired
    private AlipayService alipayService;

    @PostMapping("pay/alipayOrder.do")
    @ApiOperation (value = "创建支付二维码")
    public ResultVo save(AlipayOrder alipayOrder){
        return alipayService.savePay (alipayOrder);
    }

    @GetMapping("pay/alipayNotify.do")
    public void notify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IOUtils.toString (request.getInputStream (),"UTF-8");
        response.getWriter ().print ("success");
    }

    @GetMapping("pay/alipayQuery,do")
    @ApiOperation (value = "查询订单状态")
    public ResultVo query(String tradeno){
        return alipayService.queryPay (tradeno);
    }

    @ApiOperation (value = "查询对账单，按天查询")
    @GetMapping("pay/alipayBillday.do")
    public ResultVo down(String date){
        return alipayService.queryBill (date);
    }

    @ApiOperation (value = "查询对账单，按月查询")
    @GetMapping("pay/alipayBillmonth")
    public ResultVo downMonth(String month){
        return alipayService.queryBill (month);
    }





}
