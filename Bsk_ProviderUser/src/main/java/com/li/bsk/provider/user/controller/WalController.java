package com.li.bsk.provider.user.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import com.li.bsk.provider.user.provider.WalProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WalController {

    @Autowired
    private WalProvider walProvider;

    @GetMapping("userWal/findByWalId.do")
    public ResultVo findByWalId(String token){
        return walProvider.findByWalId (token);
    }

    @GetMapping("userWal/findByUserIdInLog")
    public List<Log> findByUserIdInLog(String token){
        return walProvider.findByUserIdInLog (token);
    }
}
