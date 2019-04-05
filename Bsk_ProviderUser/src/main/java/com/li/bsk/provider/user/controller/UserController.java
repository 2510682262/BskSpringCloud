package com.li.bsk.provider.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.User;
import com.li.bsk.provider.user.provider.UserProvider;
import com.li.bsk.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("user/verify")
    public ResultVo verify(String phone){
        return userService.verify (phone);
    }

    @PutMapping("user/backPassword")
    public void backPassword(@RequestBody User user){
        userService.backPassword (user);
    }

}
