package com.li.bsk.api.controller;

import com.li.bsk.api.provider.WalProvider;
import com.li.bsk.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户钱包相关")
public class WalController {

    @Autowired
    private WalProvider walProvider;

    @GetMapping("userWal/findByWalId.do")
    @ApiOperation (value = "用户钱包信息")
    public ResultVo findByWalId(int id){
        return walProvider.findByWalId (id);
    }
}
