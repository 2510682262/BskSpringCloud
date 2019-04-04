package com.li.bsk.provider.user.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import com.li.bsk.entity.UserLevel;
import com.li.bsk.provider.user.provider.LevProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LevelController {

    @Autowired
    private LevProvider levProvider;

    @GetMapping("userLev/findByLevId.do")
    public ResultVo findByLevId(String token){
        return ResultUtil.exec (true,"OK",levProvider.findByLevId (token));
    }

    @PutMapping("userLev/updateLevel.do")
    public void updateLevel(@RequestBody UserLevel userLevel){
        levProvider.updateLevel (userLevel);
    }

    @GetMapping("userLev/findByUserIdInLog")
    public List<Log> findByUserIdInLog(String token){
        return levProvider.findByUserIdInLog (token);
    }
}
