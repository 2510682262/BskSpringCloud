package com.li.bsk.api.provider;

import com.li.bsk.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WalProvider {

    @Autowired
    private RestTemplate restTemplate;

    public ResultVo findByWalId(int id){
        return restTemplate.getForObject ("http://liprovideruser/userWal/findByWalId.do?id=" + id,ResultVo.class);
    }


}
