package com.li.bsk.service.user;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserMessage;

public interface MessageService {

    ResultVo addMes(UserMessage userMessage);

    ResultVo findByMesId(int id);
}
