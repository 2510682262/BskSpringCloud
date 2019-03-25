package com.li.bsk.provider.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;
import com.li.bsk.provider.user.provider.UserAddrProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAddrController {

    @Autowired
    private UserAddrProvider userAddrProvider;

    @PostMapping("userAddr/addUserAddr.do")
    public ResultVo addAddr(UserAddr userAddr){
        return userAddrProvider.addAddr (userAddr);
    }

    @GetMapping("userAddr/findByUserId.do")
    public ResultVo findByUserId(int id){
        return userAddrProvider.findByUserId (id);
    }

    @GetMapping("userAddr/findByAddrId.do")
    public ResultVo findByAddrId(int id){
        return userAddrProvider.findByAddrId (id);
    }

    @PutMapping("userAddr/updateAddr.do")
    public ResultVo updateAddr(UserAddr userAddr){
        return userAddrProvider.updateAddr (userAddr);
    }

    @PostMapping("userAddr/delAddrByAddrId.do")
    public ResultVo delAddrByAddrId(int id){
        return userAddrProvider.delAddrByAddrId (id);
    }



}
