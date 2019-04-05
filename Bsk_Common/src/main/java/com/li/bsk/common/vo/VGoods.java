package com.li.bsk.common.vo;

import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsClassifyDetails;
import com.li.bsk.entity.GoodsImg;

import java.util.List;

public class VGoods {

    private Goods goods;
    private List<GoodsImg> goodsImgs;
    private List<GoodsClassifyDetails> details;

    public List<GoodsClassifyDetails> getDetails() {
        return details;
    }

    public void setDetails(List<GoodsClassifyDetails> details) {
        this.details = details;
    }

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
