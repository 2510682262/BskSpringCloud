package com.li.bsk.common.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsImg;

import java.math.BigDecimal;
import java.util.List;

public class VGoods {

    private Goods goods;
    private List<GoodsImg> goodsImgs;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsImg> getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(List<GoodsImg> goodsImgs) {
        this.goodsImgs = goodsImgs;
    }
}
