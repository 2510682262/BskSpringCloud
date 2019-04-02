package com.li.bsk.provider.goods.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.vo.VShop;
import com.li.bsk.entity.Shop;
import com.li.bsk.service.goods.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("shop/addShop")
    public ResultVo addShop(@RequestBody Shop shop, String token){
        return shopService.addShop (shop,token);
    }

    @DeleteMapping("shop/delShopById")
    public void delShop(int id){
        shopService.delShop (id);
    }

    @PutMapping("shop/updateShopById")
    public void updateShop(@RequestBody Shop shop){
        shopService.updateShop (shop);
    }

    @GetMapping("shop/findByUserId")
    public List<VShop> findByUserId(String token){
        return shopService.findByUserId (token);
    }
}
