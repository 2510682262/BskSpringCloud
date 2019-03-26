package com.li.bsk.api.controller;

import com.li.bsk.api.provider.AddrProvider;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "收货地址相关接口")
public class AddrController {

    @Autowired
    private AddrProvider addrProvider;

    @PostMapping("userAddr/addUserAddr.do")
    @ApiOperation (value = "新增收货地址")
    public ResultVo addAddr(UserAddr userAddr, String token){

        int id = TokenUtil.parseToken (token);
        userAddr.setUserId (id);
        return addrProvider.addAddr (userAddr);
    }

    @GetMapping("userAddr/findByUserId.do")
    @ApiOperation (value = "用户具体的收货地址")
    public ResultVo findByUserId(String token){

        int id = TokenUtil.parseToken (token);
        return addrProvider.findByUserId (id);

    }

    @GetMapping("userAddr/findByAddrId.do/{id}")
    @ApiOperation (value = "根据收货地址id查找收货地址")
    public ResultVo findByAddrId(@PathVariable int id){
        return addrProvider.findByAddrId (id);
    }

    @PutMapping("userAddr/updateAddr.do")
    @ApiOperation (value = "修改收货地址")
    public ResultVo updateAddr(UserAddr userAddr){
        return addrProvider.updateAddr (userAddr);
    }

    @DeleteMapping("userAddr/delAddrByAddrId.do/{id}")
    @ApiOperation (value = "删除收货地址")
    public ResultVo delAddrByAddrId(@PathVariable int id){
        return addrProvider.delAddrByAddrId (id);
    }
}
