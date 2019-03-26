package com.li.bsk.api.controller;

import com.li.bsk.api.provider.MesProvider;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户个人信息相关")
public class MesController {

    @Autowired
    private MesProvider mesProvider;

    @PostMapping("userMes/addMes.do")
    @ApiOperation (value = "添加或修改用户信息")
    public ResultVo addMes(UserMessage userMessage){
        return mesProvider.addMes (userMessage);
    }

    @GetMapping("userMes/findByMesId.do")
    @ApiOperation (value = "查找用户信息")
    public ResultVo findByMesId(int id){
        return mesProvider.findByMesId (id);
    }


}
