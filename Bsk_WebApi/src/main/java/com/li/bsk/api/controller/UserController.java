package com.li.bsk.api.controller;

import com.li.bsk.api.provider.UserProvider;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用户相关操作")
public class UserController {

    @Autowired
    private UserProvider userProvider;

    @PostMapping("user/userAdd.do")
    @ApiOperation (value = "用户注册")
    public ResultVo register(User user){
        return userProvider.register (user);
    }

    @GetMapping("user/user.do/{id}")
    public ResultVo findUserById(@PathVariable int id){
        return userProvider.findUserById (id);
    }


}
