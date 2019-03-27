package com.li.bsk.provider.user.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserLevel;
import com.li.bsk.mapper.UserLevelMapper;
import com.li.bsk.service.user.LevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevProvider implements LevService {

    @Autowired
    private UserLevelMapper userLevelMapper;

    @Override
    public ResultVo findByLevId(int id) {
        return ResultUtil.exec (true,"OK",userLevelMapper.selectById (id));
    }

    @Override
    public void updateLevel(UserLevel userLevel) {
        userLevel.setLevelExp (userLevel.getLevelExp () + 1);
        userLevelMapper.updateById (userLevel);
    }
}
