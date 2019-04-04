package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import com.li.bsk.entity.UserLevel;

import java.util.List;

public interface LevService {

    ResultVo findByLevId(String token);

    ResultVo updateLevel(UserLevel userLevel);

    List<Log> findByUserIdInLog(String token);
}
