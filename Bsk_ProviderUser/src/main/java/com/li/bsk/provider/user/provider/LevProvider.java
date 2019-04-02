package com.li.bsk.provider.user.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
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
    public ResultVo findByLevId(String token) {
        return ResultUtil.exec (true,"OK",userLevelMapper.selectById (TokenUtil.parseToken (token)));
    }

    @Override
    public ResultVo updateLevel(UserLevel userLevel) {

        UserLevel userLevel1 = userLevelMapper.selectById (userLevel.getLevelId ());
        userLevel.setLevelExp (userLevel1.getLevelExp () + 1);
        if (userLevel.getLevelExp () >= 10000){
            userLevel.setLevelName ("蛋糕至尊");
        } else if (userLevel.getLevelExp () > 5000){
            userLevel.setLevelName ("蛋糕王者");
        } if (userLevel.getLevelExp () > 1000){
            userLevel.setLevelName ("热爱");
        }
        return ResultUtil.exec (userLevelMapper.updateById (userLevel) > 0,"OK",null);
    }
}
