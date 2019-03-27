package com.li.bsk.login.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.bsk.common.util.JedisUtil;
import com.li.bsk.common.util.PassUtil;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import com.li.bsk.entity.User;
import com.li.bsk.common.sysconst.SystemConst;
import com.li.bsk.login.service.LoginService;
import com.li.bsk.mapper.LogMapper;
import com.li.bsk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2019/3/19 14:19
 */
@Service
public class LoginProvider implements LoginService {

    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;

    @Override
    public ResultVo login(String userPhone, String userPassword, String ip) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User> ().eq ("user_phone", userPhone);
        User user = userMapper.selectOne (queryWrapper);
        if (user != null){
            if (userPassword.equals (user.getUserPassword ())){
                String token = TokenUtil.createToken (user.getUserId (), userPhone);
                jedisUtil.save (SystemConst.PHONETOKEN,userPhone,token);
                jedisUtil.save (SystemConst.LOGINTOKEN,token, JSON.toJSONString (user));
                Log log = new Log ();
                log.setLogType (1);
                log.setLogCreatetime (new Date ());
                log.setUserId (user.getUserId ());
                logMapper.insert (log);
                System.out.println (token);

                return ResultUtil.exec (true,"OK",token);

            }
        }

        return ResultUtil.exec (false,"用户名或密码不正确",null);
    }

    @Override
    public ResultVo check(String token) {
        
        if (jedisUtil.isHave (SystemConst.LOGINTOKEN,token)){
            return ResultUtil.exec (true,"OK",JSON.parseObject (jedisUtil.get (SystemConst.LOGINTOKEN,token),User.class));
        }
        return ResultUtil.exec(false,"登录失效",null);
    }

    @Override
    public ResultVo exit(String token) {
        if (jedisUtil.isHave (SystemConst.LOGINTOKEN,token)){
            jedisUtil.del (SystemConst.LOGINTOKEN,token);
            String msg = PassUtil.base64Dec (token, "UTF-8");
            String[] split = msg.split (",");
            jedisUtil.del (SystemConst.PHONETOKEN, split[1]);
        }

        return null;
    }
}
