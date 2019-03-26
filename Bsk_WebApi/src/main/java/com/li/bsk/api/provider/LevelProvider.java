package com.li.bsk.api.provider;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LevelProvider {

    @Autowired
    private RestTemplate restTemplate;

    public ResultVo findByLevId(int id){
        return restTemplate.getForObject ("http://liprovideruser/userLev/findByLevId.do?id=" + id,ResultVo.class);
    }

    public ResultVo updateLevel(UserLevel userLevel){
        return null;
    }
}
