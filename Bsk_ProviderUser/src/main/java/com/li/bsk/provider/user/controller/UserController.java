package com.li.bsk.provider.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.User;
import com.li.bsk.provider.user.provider.UserProvider;
import com.li.bsk.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user/userAdd.do")
    public ResultVo register(@RequestBody User user){
        return userService.save (user);
    }

    @GetMapping("user/user.do")
    public ResultVo queryBuId(String token){
        return userService.queryById (token);
    }

}
