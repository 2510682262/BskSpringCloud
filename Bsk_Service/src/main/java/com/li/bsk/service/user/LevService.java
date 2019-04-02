package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserLevel;

public interface LevService {

    ResultVo findByLevId(String token);

    ResultVo updateLevel(UserLevel userLevel);
}
