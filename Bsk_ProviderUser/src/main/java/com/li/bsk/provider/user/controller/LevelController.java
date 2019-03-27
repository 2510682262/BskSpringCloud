package com.li.bsk.provider.user.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserLevel;
import com.li.bsk.provider.user.provider.LevProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelController {

    @Autowired
    private LevProvider levProvider;

    @GetMapping("userLev/findByLevId.do")
    public ResultVo findByLevId(int id){
        return ResultUtil.exec (true,"OK",levProvider.findByLevId (id));
    }

    @PostMapping("userLev/updateLevel.do")
    public void updateLevel(@RequestBody UserLevel userLevel){
        levProvider.updateLevel (userLevel);
    }
}
