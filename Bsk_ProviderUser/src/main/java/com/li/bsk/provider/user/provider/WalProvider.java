package com.li.bsk.provider.user.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.mapper.UserWalletMapper;
import com.li.bsk.service.user.WalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalProvider implements WalService {

    @Autowired
    private UserWalletMapper userWalletMapper;

    @Override
    public ResultVo findByWalId(int id) {
        return ResultUtil.exec (true,"OK",userWalletMapper.selectById (id));
    }
}
