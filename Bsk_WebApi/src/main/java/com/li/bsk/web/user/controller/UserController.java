package com.li.bsk.web.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "用户相关操作")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("user/userAdd.do")
    @ApiOperation (value = "用户注册")
    public ResultVo register(User user){

        return restTemplate.postForObject ("http://liprovideruser/user/addUser.do",user,ResultVo.class);
    }

    @GetMapping("user/user.do/{id}")
    public ResultVo findUserById(@PathVariable int id){
        return restTemplate.getForObject ("http://liprovideruser/user/user.do?id=" + id,
                ResultVo.class);
    }


}
