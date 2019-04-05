package com.li.bsk.common.vo;

import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsClassifyDetails;

import java.math.BigDecimal;

public class VShop {

    private Integer shopId;
    private Integer shopNum;
    private BigDecimal shopTotalprice;
    private Integer userId;
    private Integer goodsId;
    private Integer classifyId;

    private Goods goods;
    private GoodsClassifyDetails goodsClassifyDetails;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    public BigDecimal getShopTotalprice() {
        return shopTotalprice;
    }

    public void setShopTotalprice(BigDecimal shopTotalprice) {
        this.shopTotalprice = shopTotalprice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsClassifyDetails getGoodsClassifyDetails() {
        return goodsClassifyDetails;
    }

    public void setGoodsClassifyDetails(GoodsClassifyDetails goodsClassifyDetails) {
        this.goodsClassifyDetails = goodsClassifyDetails;
    }
}
