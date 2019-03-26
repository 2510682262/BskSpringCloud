package com.li.bsk.api.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;
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
public class AddrProvider {

    @Autowired
    private RestTemplate restTemplate;

    public ResultVo addAddr(UserAddr userAddr){

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

        return restTemplate.postForObject ("http://liprovideruser/userAddr/addUserAddr.do", userAddr, ResultVo.class);

    }

    public ResultVo findByUserId(int id){

        return restTemplate.getForObject ("http://liprovideruser/userAddr/findByUserId.do?id=" + id,
                ResultVo.class);
    }

    public ResultVo findByAddrId(int id){

        return restTemplate.getForObject ("http://liprovideruser/userAddr/findByAddrId.do?id=" + id,
                ResultVo.class);
    }

    public ResultVo updateAddr(UserAddr userAddr){

        Map<String, Object> param = new HashMap<> ();
        param.put ("addrPhone",userAddr.getAddrPhone ());
        param.put ("addrShipping",userAddr.getAddrShipping ());
        param.put ("addrShippinginfo",userAddr.getAddrShippinginfo ());
        param.put ("addrDefault",userAddr.getAddrDefault ());
        param.put ("addrName",userAddr.getAddrName ());
        param.put ("userId",userAddr.getUserId ());
        HttpHeaders httpHeaders = new HttpHeaders ();
        httpHeaders.setContentType (MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<> (param, httpHeaders);

        try {
            restTemplate.put ("http://liprovideruser/userAddr/updateAddr.do",httpEntity);
            return ResultUtil.exec (true,"OK",null);
        } catch (RestClientException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR",null);

        }
//        return restTemplate.postForObject ("http://liprovideruser/userAddr/updateAddr.do", httpEntity, ResultVo.class);
    }

    public ResultVo delAddrByAddrId(int id){

        return restTemplate.getForObject ("http://liprovideruser/userAddr/delAddrByAddrId.do?id=" + id, ResultVo.class);
    }

}
