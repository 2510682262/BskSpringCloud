package com.li.bsk.web.user.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.UserLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "用户等级相关")
public class LevelController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("userLev/findByLevId.do")
    @ApiOperation (value = "查询用户等级信息")
    public ResultVo findByLevId(String token){
        return restTemplate.getForObject ("http://liprovideruser/userLev/findByLevId.do?token=" + token,ResultVo.class);
    }

    @PutMapping("userLev/updateLevel.do")
    @ApiOperation (value = "修改用户等级信息")
    public ResultVo updateLevel(UserLevel userLevel, String token){
        userLevel.setLevelId (TokenUtil.parseToken (token));
        restTemplate.put ("http://liprovideruser/userLev/updateLevel.do",userLevel);
        return ResultUtil.exec (true,"OK",null);

    }
}
