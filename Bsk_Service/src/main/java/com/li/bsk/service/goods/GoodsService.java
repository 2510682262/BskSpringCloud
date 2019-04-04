package com.li.bsk.service.goods;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsImg;

import java.util.List;

public interface GoodsService {

    Goods findByGoodsId(int id);

    ResultVo addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteByGoodsId(int id);

    List<GoodsImg> selectByGoodsId(int id);

    List<Goods> selectByGoodsType(int type);

    List<Goods> selectByGoodsGenre(int genre);

}
