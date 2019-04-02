package com.li.bsk.web.goods.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.vo.VShop;
import com.li.bsk.entity.Shop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Api(value = "购物车相关操作")
public class ShopController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("shop/addShop")
    @ApiOperation (value = "添加购物车")
    public ResultVo addShop(Shop shop, String token){
        return restTemplate.postForObject ("http://liprovidergoods/shop/addShop?token=" + token,shop,ResultVo.class);
    }

    @DeleteMapping("shop/delShopById")
    @ApiOperation (value = "根据id删除购车")
    public ResultVo delShop(int id){
        try {
            restTemplate.delete ("http://liprovidergoods/shop/delShopById?id=" + id);
            return ResultUtil.exec (true,"OK",null);
        } catch (RestClientException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR",null);
        }
    }

    @PutMapping("shop/updateShopById")
    @ApiOperation (value = "根据id修改购物车")
    public ResultVo updateShop(Shop shop){
        try {
            restTemplate.put ("http://liprovidergoods/shop/updateShopById",shop);
            return ResultUtil.exec (true,"OK",null);

        } catch (RestClientException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR",null);
        }
    }

    @GetMapping("shop/findByUserId")
    @ApiOperation (value = "根据用户id，查询购物车")
    public List<VShop> findByUserId(String token){
        VShop[] forObject = restTemplate.getForObject ("http://liprovidergoods/shop/findByUserId?token=" + token, VShop[].class);
        List<VShop> vShops = Arrays.asList (forObject);
        return vShops;
    }
}
