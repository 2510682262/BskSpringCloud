package com.li.bsk.pay.provider;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.li.bsk.common.util.Base64Util;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.pay.entity.AlipayOrder;
import com.li.bsk.pay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

@Service
public class AlipayProvider implements AlipayService {

    @Autowired
    private AlipayClient client;

    @Override
    public ResultVo savePay(AlipayOrder alipayOrder) {

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest ();
        request.setBizContent (JSON.toJSONString (alipayOrder));
        request.setNotifyUrl ("http://localhost:16888/pay/alipayNotify.do");

        try {
            AlipayTradePrecreateResponse response = client.execute (request);
            if (response.isSuccess ()){
                String msg = response.getQrCode ();
                String passmsg = Base64Util.base64Enc (msg.getBytes ());
                return ResultUtil.exec (true,"OK","http://localhost:16888/qrcodepay.do/"+passmsg);
            }
        } catch (AlipayApiException e) {
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public ResultVo queryPay(String trandon) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest ();
        request.setBizContent ("{\"out_trade_no\":\""+ trandon +"\"}");
        AlipayTradeQueryResponse response = null;
        try {
            response = client.execute (request);
            if (response.isSuccess ()){
                return ResultUtil.exec (true,response.getTradeStatus (),response);
            }
        } catch (AlipayApiException e) {
            e.printStackTrace ();
        }

        return ResultUtil.exec (false,"暂无该订单",null);

    }

    @Override
    public ResultVo queryBill(String date) {
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest ();
        request.setBizContent ("{\"bill_type\":\"trade\",\"bill_date\":\":\""+ date +"\"}");
        AlipayDataDataserviceBillDownloadurlQueryResponse response = null;

        try {
            response = client.execute (request);
            if (response.isSuccess ()){
                return ResultUtil.exec (true,"对账单下载地址",response.getBillDownloadUrl ());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace ();
        }
        return ResultUtil.exec (false,"暂无对账单",null);
    }
}
