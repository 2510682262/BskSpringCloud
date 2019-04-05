package com.li.bsk.web.user.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "用户相关操作")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("user/userAdd.do")
    @ApiOperation (value = "用户注册")
    public ResultVo register(User user){
        return restTemplate.postForObject ("http://liprovideruser/user/userAdd.do",user,ResultVo.class);
    }

    @GetMapping("user/user.do")
    public ResultVo findUserById(String token){
        return restTemplate.getForObject ("http://liprovideruser/user/user.do?token=" + token,
                ResultVo.class);
    }

    public ResultVo getUserError(User user){
        return ResultUtil.exec (false,"ERROR",user);
    }

    @GetMapping("user/verify")
    @ApiOperation (value = "验证手机号")
    public ResultVo verify(String phone){
        return restTemplate.getForObject ("http://liprovideruser/user/verify?phone=" + phone,ResultVo.class);
    }

    @PutMapping("user/backPassword")
    @ApiOperation (value = "修改密码")
    public ResultVo backPassword(User user){
        try {
            restTemplate.put ("http://liprovideruser/user/backPassword",user);
            return ResultUtil.exec (true,"OK","修改成功");
        } catch (RestClientException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR","密码修改失败");
        }
    }

}
