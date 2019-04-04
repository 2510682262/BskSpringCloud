package com.li.bsk.web.user.controller;

import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Api(value = "用户钱包相关")
public class WalController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("userWal/findByWalId.do")
    @ApiOperation (value = "用户钱包信息")
    public ResultVo findByWalId(String token){
        return restTemplate.getForObject ("http://liprovideruser/userWal/findByWalId.do?token=" + token,ResultVo.class);
    }

    @GetMapping("userWal/findByUserIdInLog")
    @ApiOperation (value = "查询用户钱包相关日志")
    public List<Log> findByUserIdInLog(String token){
        Log[] forObject = restTemplate.getForObject ("http://liprovideruser/userWal/findByUserIdInLog?token=" + token, Log[].class);
        List<Log> logs = Arrays.asList (forObject);
        return logs;
    }
}
