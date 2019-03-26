package com.li.bsk.provider.user.provider;

import com.li.bsk.common.util.ResultUtil;
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
    public ResultVo addAddr(UserAddr userAddr) {

        int insert = userAddrMapper.insert (userAddr);
        return ResultUtil.exec (insert > 0,"OK", null);
    }

    @Override
    public ResultVo findByUserId(int id) {

        return ResultUtil.exec (true,"OK",userAddrMapper.findByUserId (id));
    }

    @Override
    public ResultVo findByAddrId(int id) {
        return ResultUtil.exec (userAddrMapper.selectById (id) != null,"Ok",userAddrMapper.selectById (id));
    }

    @Override
    public ResultVo updateAddr(UserAddr userAddr) {
        int i = userAddrMapper.updateById (userAddr);
        return ResultUtil.exec (i > 0,"OK",null);
    }

    @Override
    public ResultVo delAddrByAddrId(int id) {
        UserAddr userAddr = userAddrMapper.selectById (id);
        if (userAddr != null){
            userAddrMapper.deleteById (id);
            return ResultUtil.exec (true,"OK",null);
        }
        return ResultUtil.exec (false,"要删除的地址不存在",null);
    }
}
