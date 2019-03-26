package com.li.bsk.api.controller;

import com.li.bsk.api.provider.LevelProvider;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户等级相关")
public class LevelController {

    @Autowired
    private LevelProvider levelProvider;

    @GetMapping("userLev/findByLevId.do")
    @ApiOperation (value = "查询用户等级信息")
    public ResultVo findByLevId(int id){
        return levelProvider.findByLevId (id);
    }

    @PostMapping("userLev/updateLevel.do")
    @ApiOperation (value = "修改用户等级信息")
    public ResultVo updateLevel(UserLevel userLevel){
        levelProvider.updateLevel (userLevel);
        return ResultUtil.exec (true,"OK",null);
    }
}
