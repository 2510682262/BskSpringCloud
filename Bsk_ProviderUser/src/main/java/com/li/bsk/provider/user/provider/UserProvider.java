package com.li.bsk.provider.user.provider;

import com.li.bsk.common.sysconst.SystemCon;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.*;
import com.li.bsk.mapper.*;
import com.li.bsk.service.user.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public ResultVo save(User user) {

        User user1 = userMapper.selectByName (user.getUserPhone ());
        if (user1 != null){
            return ResultUtil.exec (false,"ERROR","用户名已存在");
        } else {
            userMapper.insert (user);
            Log log = new Log ();
            log.setLogCreatetime (new Date ());
            log.setLogInfo ("注册");
            log.setLogType (SystemCon.STREAMLOGOP);
            // 差一个用户id
            logMapper.insert (log);
            userLevelMapper.insert (new UserLevel ());
            userMessageMapper.insert (new UserMessage ());
            userWalletMapper.insert (new UserWallet ());

            return ResultUtil.exec (true,"OK",null);
        }

    }

    @Override
    public ResultVo queryById(int id) {

        return ResultUtil.exec (userMapper.selectById (id) != null,"OK",userMapper.selectById (id));
    }
}
