package com.li.bsk.login.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2019/3/13 10:55
 */
//@WebFilter("/*")
public class CrosFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        //设置允许跨域
        response.setHeader("Access-Control-Allow-Origin",request.getRemoteHost());
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers","Content-Type,usertoken");
        response.setHeader("Access-Control-Allow-Credentials","true");

        filterChain.doFilter(servletRequest,response);
    }
}