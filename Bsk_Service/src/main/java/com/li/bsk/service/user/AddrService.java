package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;

public interface AddrService {

    ResultVo addAddr(UserAddr userAddr);

    ResultVo findByUserId(int id);

    ResultVo findByAddrId(int id);

    void updateAddr(UserAddr userAddr);

    void delAddrByAddrId(int id);
}
