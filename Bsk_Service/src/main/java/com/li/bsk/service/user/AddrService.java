package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;

public interface AddrService {

    ResultVo addAddr(UserAddr userAddr, String token);

    ResultVo findByUserId(String token);

    ResultVo findByAddrId(int id);

    void updateAddr(UserAddr userAddr);

    void delAddrByAddrId(int id);
}
