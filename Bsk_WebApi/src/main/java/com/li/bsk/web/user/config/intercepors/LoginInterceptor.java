package com.li.bsk.web.user.config.intercepors;

import com.li.bsk.common.util.JedisUtil;
import com.li.bsk.common.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String token = request.getParameter ("token");
        int i = TokenUtil.parseToken (token);
        if (i != -1){
            return true;
        } else {
            return false;
        }

    }
}
