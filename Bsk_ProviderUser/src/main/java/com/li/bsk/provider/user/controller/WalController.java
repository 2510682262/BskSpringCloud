package com.li.bsk.provider.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.provider.user.provider.WalProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalController {

    @Autowired
    private WalProvider walProvider;

    @GetMapping("userWal/findByWalId.do")
    public ResultVo findByWalId(int id){
        return walProvider.findByWalId (id);
    }
}
