package com.li.bsk.web.user.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserAddr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "收货地址相关接口")
public class AddrController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("userAddr/addUserAddr.do")
    @ApiOperation (value = "新增收货地址")
    public ResultVo addAddr(UserAddr userAddr, String token){

        int id = TokenUtil.parseToken (token);
        userAddr.setUserId (id);
        return restTemplate.postForObject ("http://liprovideruser/userAddr/addUserAddr.do", userAddr, ResultVo.class);
    }

    @GetMapping("userAddr/findByUserId.do")
    @ApiOperation (value = "用户具体的收货地址")
    public ResultVo findByUserId(String token){

        int id = TokenUtil.parseToken (token);
        return restTemplate.getForObject ("http://liprovideruser/userAddr/findByUserId.do?id=" + id,
                ResultVo.class);
    }

    @GetMapping("userAddr/findByAddrId.do/{id}")
    @ApiOperation (value = "根据收货地址id查找收货地址")
    public ResultVo findByAddrId(@PathVariable int id){
        return restTemplate.getForObject ("http://liprovideruser/userAddr/findByAddrId.do?id=" + id,
                ResultVo.class);
    }

    @PutMapping("userAddr/updateAddr.do")
    @ApiOperation (value = "修改收货地址")
    public ResultVo updateAddr(@RequestBody UserAddr userAddr){
        try {
            restTemplate.put ("http://liprovideruser/userAddr/updateAddr.do",userAddr);
            return ResultUtil.exec (true,"OK",null);
        } catch (RestClientException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR",null);
        }
    }

    @DeleteMapping("userAddr/delAddrByAddrId.do/{id}")
    @ApiOperation (value = "删除收货地址")
    public ResultVo delAddrByAddrId(@PathVariable int id){
        return restTemplate.getForObject ("http://liprovideruser/userAddr/delAddrByAddrId.do?id=" + id, ResultVo.class);
    }
}
