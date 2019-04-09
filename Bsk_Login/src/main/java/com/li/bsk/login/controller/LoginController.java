package com.li.bsk.login.controller;

import com.li.bsk.common.util.IsTokenUtil;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.sysconst.SystemConst;
import com.li.bsk.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2019/3/19 10:14
 */
@RestController
@Api(value = "登录相关")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录接口
    @PostMapping("userlogin.do")
    @ApiOperation (value = "登陆接口")
    public ResultVo login(String userPhone, String userPassword, HttpServletRequest request, HttpServletResponse response){
        String token = null;
        try {
            token = IsTokenUtil.isToken (request);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        ResultVo resultVo = null;
        if (token.length () > 0){
            resultVo = loginService.check (token);
        } else {
            resultVo = loginService.login (userPhone,userPassword,request.getRemoteAddr ());
            if (resultVo.getCode () == 1){
                Cookie cookie = new Cookie (SystemConst.COOKIETOKEN, resultVo.getData ().toString ());
                cookie.setPath ("/");
                cookie.setDomain ("");
                response.addCookie (cookie);
            }
        }

        return resultVo;
    }
    //注销接口
    @GetMapping("userexit.do")
    @ApiOperation (value = "注销接口")
    public ResultVo exit(HttpServletRequest request,HttpServletResponse response){

        String token = IsTokenUtil.isToken (request);
        if (token.length () > 0){
            loginService.exit (token);
            Cookie cookie = new Cookie (SystemConst.COOKIETOKEN, "");
            cookie.setMaxAge (0);
            response.addCookie (cookie);
        }

        return ResultUtil.exec(true,"OK",null);
    }

    //校验是否登录有效性
    @GetMapping("usercheck.do")
    @ApiOperation ("校验接口")
    public ResultVo check(HttpServletRequest request){

        String token = IsTokenUtil.isToken (request);
        ResultVo resultVo = null;
        if (token.length () > 0){
            resultVo = loginService.check (token);
        } else {
            resultVo = ResultUtil.exec (false,"登录无效",null);
        }

        return resultVo;
    }
}
