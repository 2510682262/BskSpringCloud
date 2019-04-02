package com.li.bsk.provider.user.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserMessage;
import com.li.bsk.mapper.UserMessageMapper;
import com.li.bsk.service.user.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesProvider implements MessageService {

    @Autowired
    private UserMessageMapper userMessageMapper;


    @Override
    public ResultVo addMes(UserMessage userMessage) {

        UserMessage userMessage1 = userMessageMapper.selectById (userMessage.getMesId ());
        if (userMessage1 == null){
            userMessageMapper.insert (userMessage);
        } else {
            userMessageMapper.updateById (userMessage);
        }
        return ResultUtil.exec (true,"OK",null);
    }

    @Override
    public ResultVo findByMesId(String token) {
        return ResultUtil.exec (true,"OK",userMessageMapper.selectById (TokenUtil.parseToken (token)));
    }
}
