package com.li.bsk.web.goods.controller;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Goods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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
        return restTemplate.getForObject ("http://liprovidergoods/goods/findByGoodsId.do?id=" + id,ResultVo.class);
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
