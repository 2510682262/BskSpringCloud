package com.li.bsk.web.goods.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.vo.VGoods;
import com.li.bsk.common.vo.VShop;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsClassifyDetails;
import com.li.bsk.entity.GoodsImg;
import com.li.bsk.entity.Orderform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Api(value = "商品相关接口")
public class GoodsController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("goods/addGoods.do")
    @ApiOperation (value = "添加商品")
    public ResultVo addGoods(Goods goods){
        return restTemplate.postForObject ("http://liprovidergoods/goods/addGoods.do", goods, ResultVo.class);
    }

    @GetMapping("goods/findByGoodsId.do")
    @ApiOperation (value = "根据商品id查找商品")
    public ResultVo findByGoodsId(int id){

        Goods goods = restTemplate.getForObject ("http://liprovidergoods/goods/findByGoodsId.do?id=" + id, Goods.class);
        if (goods != null){
            GoodsImg[] forObject1 = restTemplate.getForObject ("http://liprovidergoods/goods/findByGoods.do?id=" + id, GoodsImg[].class);
            GoodsClassifyDetails[] forObject = restTemplate.getForObject ("http://liprovidergoods/goods/selectByGoodsIdInDetails?id=" + id, GoodsClassifyDetails[].class);
            List<GoodsClassifyDetails> goodsClassifyDetails = Arrays.asList (forObject);
            List<GoodsImg> goodsImgs = Arrays.asList (forObject1);
            VGoods vGoods = new VGoods ();
            vGoods.setGoods (goods);
            vGoods.setGoodsImgs (goodsImgs);
            vGoods.setDetails (goodsClassifyDetails);
            return ResultUtil.exec (true,"OK",vGoods);
        }

        return null;

    }

    @PutMapping("goods/updateGoods.do")
    @ApiOperation (value = "修改商品")
    public ResultVo updateGoods(Goods goods){
        try {
            restTemplate.put ("http://liprovidergoods/goods/updateGoods.do",goods);
            return ResultUtil.exec (true,"OK",null);
        } catch (RestClientException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR",null);
        }
    }

    @DeleteMapping("goods/delByGoodsId.do")
    @ApiOperation (value = "删除商品")
    public ResultVo delByGoodsId(int id){

        try {
            restTemplate.delete ("http://liprovidergoods/goods/delByGoodsId.do?id=" + id);
            return ResultUtil.exec (true,"OK",null);
        } catch (RestClientException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR",null);
        }
    }

    @GetMapping("goods/selectByGoodsType")
    @ApiOperation (value = "根据菜单找对应商品")
    public ResultVo selectByGoodsType(int type){
        Goods[] forObject = restTemplate.getForObject ("http://liprovidergoods/goods/selectByGoodsType?type=" + type, Goods[].class);
        List<Goods> goods = Arrays.asList (forObject);
        return ResultUtil.exec (goods != null,"OK",goods);
    }

    @GetMapping("goods/selectByGoodsGenre")
    @ApiOperation (value = "根据菜单找对应商品")
    public ResultVo selectByGoodsGenre(int genre){
        Goods[] forObject = restTemplate.getForObject ("http://liprovidergoods/goods/selectByGoodsGenre?genre=" + genre, Goods[].class);
        List<Goods> goods = Arrays.asList (forObject);
        return ResultUtil.exec (goods != null,"OK",goods);
    }

    /*@GetMapping("goods/selectByMenuId")
    @ApiOperation (value = "点击菜单显示对应商品")
    public ResultVo selectByMenuId(int menuId, int page, int limit){
        Goods[] forObject = restTemplate.getForObject ("http://liprovidergoods/goods/selectByMenuId?menuId=" + menuId + "&page=" + page + "&limit=" + limit, IPage<T>.class);
        List<Goods> goods = Arrays.asList (forObject);
        return ResultUtil.exec (goods != null,"OK",goods);
    }*/

    @PostMapping("goods/addOrderform")
    @ApiOperation (value = "添加订单")
    public ResultVo addOrderform(Orderform orderform, String token){
        orderform.setUserId (TokenUtil.parseToken (token));
        return restTemplate.postForObject ("http://liprovidergoods/goods/addOrderform",orderform,ResultVo.class);
    }
}
