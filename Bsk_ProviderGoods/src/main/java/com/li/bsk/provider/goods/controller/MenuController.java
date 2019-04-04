package com.li.bsk.provider.goods.controller;

import com.li.bsk.entity.Menu;
import com.li.bsk.service.goods.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("menu/selectByMenuLev")
    public List<Menu> selectByMenuLev(int level){
        return menuService.selectByMenuLev (level);
    }
}
