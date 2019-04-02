package com.li.bsk.provider.user.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;
import com.li.bsk.mapper.UserAddrMapper;
import com.li.bsk.service.user.AddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddrProvider implements AddrService {

    @Autowired
    private UserAddrMapper userAddrMapper;

    @Override
    public ResultVo addAddr(UserAddr userAddr, String token) {


        userAddr.setUserId (TokenUtil.parseToken (token));
        return ResultUtil.exec (userAddrMapper.insert (userAddr) > 0,"OK", null);
    }

    @Override
    public ResultVo findByUserId(String token) {

        return ResultUtil.exec (true,"OK",userAddrMapper.findByUserId (TokenUtil.parseToken (token)));
    }

    @Override
    public ResultVo findByAddrId(int id) {
        return ResultUtil.exec (userAddrMapper.selectById (id) != null,"Ok",userAddrMapper.selectById (id));
    }

    @Override
    public void updateAddr(UserAddr userAddr) {
        userAddrMapper.updateById (userAddr);
    }

    @Override
    public void delAddrByAddrId(int id) {
        UserAddr userAddr = userAddrMapper.selectById (id);
        if (userAddr != null){
            userAddrMapper.deleteById (id);
        }
    }
}
