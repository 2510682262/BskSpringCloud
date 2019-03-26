package com.li.bsk.api.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;
import com.li.bsk.entity.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MesProvider {

    @Autowired
    private RestTemplate restTemplate;

    public ResultVo addMes(UserMessage userMessage){

        /*Map<String, Object> param = new HashMap<> ();
        param.put ("addrPhone",userAddr.getAddrPhone ());
        param.put ("addrShipping",userAddr.getAddrShipping ());
        param.put ("addrShippinginfo",userAddr.getAddrShippinginfo ());
        param.put ("addrDefault",userAddr.getAddrDefault ());
        param.put ("addrName",userAddr.getAddrName ());
        param.put ("userId",userAddr.getUserId ());
        HttpHeaders httpHeaders = new HttpHeaders ();
        httpHeaders.setContentType (MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<> (param, httpHeaders);*/

        return restTemplate.postForObject ("http://liprovideruser/userMes/addUserMes.do", userMessage, ResultVo.class);

    }

    public ResultVo findByMesId(int id){

        return restTemplate.getForObject ("http://liprovideruser/userMes/findByMesId.do?id=" + id,
                ResultVo.class);
    }

}