package com.li.bsk.login.service;

import com.li.bsk.common.vo.ResultVo;

public interface LoginService {

    //登录
    ResultVo login(String phone, String password, String ip);
    //校验
    ResultVo check(String token);
    //退出
    ResultVo exit(String token);
}
