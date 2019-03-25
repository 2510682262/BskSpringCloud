package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.User;

public interface UserService {

    ResultVo save(User user);

    ResultVo queryById(int id);


}
