package com.li.bsk.pay.provider;

import com.li.bsk.common.util.Base64Util;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.pay.service.WxPayService;
import com.li.bsk.pay.util.WxPayUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WxPayProvider implements WxPayService {

    @Autowired
    private WxPayUtil payUtil;

    @Override
    public ResultVo createPre(Map<String, String> map) {

        Map<String, String> responseMap = payUtil.createOrder (map);
        if (responseMap.containsKey ("code_url")){
            String code_url = responseMap.get ("code_url");

            String passmsg = Base64Util.base64Enc (code_url.getBytes ());

            return ResultUtil.exec (true,"OK","http://localhost:16888/qrcodepay.do/" + passmsg);
        }

        return ResultUtil.exec(false,"微信支付异常",null);
    }

    @Override
    public ResultVo searchOrder(String orderId) {
        Map<String,String> map=payUtil.searchOrder(orderId);

        if(map.containsKey("trade_state")){
            String res="";
            switch (map.get("trade_state")){
                case "SUCCESS":res="订单支付成功";break;
                case "REFUND":res="订单转入退款";break;
                case "NOTPAY":res="订单未支付";break;
                case "CLOSED":res="订单关闭";break;
                case "USERPAYING":res="订单支付中……";break;
                case "PAYERROR":res="订单支付失败,原因："+map.get("trade_state_desc");break;
            }
            return ResultUtil.exec(true,"OK",res);
        }
        return ResultUtil.exec(true,"网络异常",null);
    }

    @Override
    public ResultVo searchBill(String billdate) {
        String res=payUtil.downbill(billdate);
        return ResultUtil.exec(true,"OK",res);
    }
}
