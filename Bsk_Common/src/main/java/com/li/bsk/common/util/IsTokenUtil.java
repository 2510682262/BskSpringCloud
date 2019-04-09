package com.li.bsk.common.util;

import com.li.bsk.common.sysconst.SystemConst;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class IsTokenUtil {

    public static String isToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies ();
        String token = "";
        if (cookies != null){
            for (Cookie c: cookies) {
                if (c.getName ().equals (SystemConst.COOKIETOKEN)){
                    token = c.getValue ();
                    break;
                }
            }
        }

        return token;
    }
}
