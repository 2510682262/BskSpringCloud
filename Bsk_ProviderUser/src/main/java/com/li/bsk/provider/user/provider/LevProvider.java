package com.li.bsk.provider.user.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.li.bsk.common.sysconst.SystemCon;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import com.li.bsk.entity.UserLevel;
import com.li.bsk.mapper.LogMapper;
import com.li.bsk.mapper.UserLevelMapper;
import com.li.bsk.service.user.LevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LevProvider implements LevService {

    @Autowired
    private UserLevelMapper userLevelMapper;
    @Autowired
    private LogMapper logMapper;

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

    @Override
    public List<Log> findByUserIdInLog(String token) {

        HashMap<String, Object> map = new HashMap<> (16);
        map.put ("log_type",SystemCon.STREAMLOGEXP);
        map.put ("user_id",TokenUtil.parseToken (token));

        return logMapper.selectByMap (map);
    }
}
