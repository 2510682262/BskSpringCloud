package com.li.bsk.api.provider;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserProvider {

    @Autowired
    private RestTemplate restTemplate;

    public ResultVo register(User user){

        Map<String, Object> param = new HashMap<> ();
        param.put ("userPhone", user.getUserPhone ());
        param.put ("userPassword", user.getUserPassword ());
        HttpHeaders httpHeaders = new HttpHeaders ();
        httpHeaders.setContentType (MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<> (param, httpHeaders);

        return restTemplate.postForObject ("http://liprovideruser/user/userAdd.do", httpEntity, ResultVo.class);

    }

    public ResultVo findUserById(int id){

        return restTemplate.getForObject ("http://liprovideruser/user/user.do?id=" + id,
                ResultVo.class);
    }

}
