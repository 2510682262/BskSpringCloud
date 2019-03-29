package com.li.bsk.service.goods;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Goods;

public interface GoodsService {

    ResultVo findByGoodsId(int id);

    ResultVo addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteByGoodsId(int id);

}
