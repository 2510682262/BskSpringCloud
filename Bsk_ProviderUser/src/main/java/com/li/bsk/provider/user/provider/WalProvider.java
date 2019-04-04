package com.li.bsk.provider.user.provider;

import com.li.bsk.common.sysconst.SystemCon;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import com.li.bsk.entity.UserWallet;
import com.li.bsk.mapper.LogMapper;
import com.li.bsk.mapper.UserWalletMapper;
import com.li.bsk.service.user.WalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WalProvider implements WalService {

    @Autowired
    private UserWalletMapper userWalletMapper;
    @Autowired
    private LogMapper logMapper;

    @Override
    public ResultVo findByWalId(String token) {
        return ResultUtil.exec (true,"OK",userWalletMapper.selectById (TokenUtil.parseToken (token)));
    }

    @Override
    public List<Log> findByUserIdInLog(String token) {

        HashMap<String, Object> map = new HashMap<> (16);
        map.put ("log_type", SystemCon.STREAMLOGACCOUNT);
        map.put ("user_id",TokenUtil.parseToken (token));
        return logMapper.selectByMap (map);
    }
}
