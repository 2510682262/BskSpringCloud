package com.li.bsk.provider.user.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.bsk.common.sysconst.SystemCon;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.*;
import com.li.bsk.mapper.*;
import com.li.bsk.service.user.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class UserProvider implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private UserLevelMapper userLevelMapper;
    @Autowired
    private UserWalletMapper userWalletMapper;
    @Autowired
    private UserMessageMapper userMessageMapper;

    @Override
    @Transactional
    public ResultVo save(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User> ().eq ("user_phone", user.getUserPhone ());
        User user1 = userMapper.selectOne (queryWrapper);
        if (user1 != null){
            return ResultUtil.exec (false,"ERROR","用户名已存在");
        } else {
            userMapper.insert (user);

           /* Log log = new Log ();
            log.setLogCreatetime (new Date ());
            log.setLogInfo ("注册");
            log.setLogType (SystemCon.STREAMLOGOP);
            // 差一个用户id
            logMapper.insert (log);*/

            UserLevel userLevel = new UserLevel ();
            userLevel.setLevelExp (0);
            userLevel.setLevelName ("垃圾");
            userLevelMapper.insert (userLevel);

            UserMessage userMessage = new UserMessage ();
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            userMessage.setMesName ("贝思客" + uuid);
            userMessageMapper.insert (userMessage);

            UserWallet userWallet = new UserWallet ();
            userWallet.setWalletTotalmoney (new BigDecimal (0));
            userWalletMapper.insert (userWallet);


            return ResultUtil.exec (true,"OK",null);
        }

    }

    @Override
    public ResultVo queryById(String token) {

        return ResultUtil.exec (userMapper.selectById (TokenUtil.parseToken (token)) != null,"OK",userMapper.selectById (TokenUtil.parseToken (token)));
    }
}
