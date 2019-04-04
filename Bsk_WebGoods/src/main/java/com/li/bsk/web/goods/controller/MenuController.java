package com.li.bsk.web.goods.controller;

import com.li.bsk.entity.Menu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Api(value = "菜单相关操作")
public class MenuController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("menu/selectByMenuLev")
    @ApiOperation (value = "根据等级查询菜单")
    public List<Menu> selectByMenuLev(int level){
        Menu[] forObject = restTemplate.getForObject ("http://liprovidergoods/menu/selectByMenuLev?level=" + level, Menu[].class);
        List<Menu> menus = Arrays.asList (forObject);
        return menus;
    }
}
