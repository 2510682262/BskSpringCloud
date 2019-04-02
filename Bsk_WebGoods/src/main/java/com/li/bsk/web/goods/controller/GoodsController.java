package com.li.bsk.web.goods.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.vo.VGoods;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsImg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
            List<GoodsImg> goodsImgs = Arrays.asList (forObject1);
            VGoods vGoods = new VGoods ();
            vGoods.setGoods (goods);
            vGoods.setGoodsImgs (goodsImgs);
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
}
