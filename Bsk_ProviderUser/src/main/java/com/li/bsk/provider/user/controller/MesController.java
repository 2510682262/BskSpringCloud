package com.li.bsk.provider.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserMessage;
import com.li.bsk.provider.user.provider.MesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MesController {

    @Autowired
    private MesProvider mesProvider;

    @PostMapping("userMes/addMes.do")
    public ResultVo addMes(@RequestBody UserMessage userMessage){
        return mesProvider.addMes (userMessage);
    }

    @GetMapping("userMes/findByMesId.do")
    public ResultVo findByMesId(int id){
        return mesProvider.findByMesId (id);
    }

}
