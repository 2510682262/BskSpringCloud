package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserLevel;

public interface LevService {

    ResultVo findByLevId(int id);

    ResultVo updateLevel(UserLevel userLevel);
}
