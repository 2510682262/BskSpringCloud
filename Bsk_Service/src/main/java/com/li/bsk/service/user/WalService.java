package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import com.li.bsk.entity.UserWallet;

import java.util.List;

public interface WalService {

    ResultVo findByWalId(String token);

    List<Log> findByUserIdInLog(String token);
}
