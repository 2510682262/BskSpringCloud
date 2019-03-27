package com.li.bsk.web.user.controller;

import com.li.bsk.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "用户钱包相关")
public class WalController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("userWal/findByWalId.do")
    @ApiOperation (value = "用户钱包信息")
    public ResultVo findByWalId(int id){
        return restTemplate.getForObject ("http://liprovideruser/userWal/findByWalId.do?id=" + id,ResultVo.class);
    }
}
