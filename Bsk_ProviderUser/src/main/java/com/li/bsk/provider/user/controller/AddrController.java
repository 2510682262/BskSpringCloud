package com.li.bsk.provider.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;
import com.li.bsk.provider.user.provider.AddrProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddrController {

    @Autowired
    private AddrProvider addrProvider;

    @PostMapping("userAddr/addUserAddr.do")
    public ResultVo addAddr(@RequestBody UserAddr userAddr, String token){
        return addrProvider.addAddr (userAddr,token);
    }

    @GetMapping("userAddr/findByUserId.do")
    public ResultVo findByUserId(String token){ return addrProvider.findByUserId (token); }

    @GetMapping("userAddr/findByAddrId.do")
    public ResultVo findByAddrId(int id){
        return addrProvider.findByAddrId (id);
    }

    @PutMapping("userAddr/updateAddr.do")
    public void updateAddr(@RequestBody UserAddr userAddr){
        addrProvider.updateAddr (userAddr);
    }

    @PostMapping("userAddr/delAddrByAddrId.do")
    public void delAddrByAddrId(int id){
        addrProvider.delAddrByAddrId (id);
    }



}
