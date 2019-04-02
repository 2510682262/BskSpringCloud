package com.li.bsk.web.user.controller;

import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "用户个人信息相关")
public class MesController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("userMes/addMes.do")
    @ApiOperation (value = "添加或修改用户信息")
    public ResultVo addMes(UserMessage userMessage){

        return restTemplate.postForObject ("http://liprovideruser/userMes/addUserMes.do", userMessage, ResultVo.class);
    }

    @GetMapping("userMes/findByMesId.do")
    @ApiOperation (value = "查找用户信息")
    public ResultVo findByMesId(String token){
        return restTemplate.getForObject ("http://liprovideruser/userMes/findByMesId.do?token=" + token,
                ResultVo.class);
    }


}
