package com.li.bsk.provider.goods.provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.vo.VGoods;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsImg;
import com.li.bsk.mapper.GoodsImgMapper;
import com.li.bsk.mapper.GoodsMapper;
import com.li.bsk.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsProvider implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsImgMapper goodsImgMapper;

    @Override
    public ResultVo findByGoodsId(int id) {
        VGoods vGoods = null;
        Goods goods = goodsMapper.selectById (id);
        List<GoodsImg> goodsImgs = goodsImgMapper.selectByGoodsId (id);
        vGoods.setGoods (goods);
        vGoods.setGoodsImgs (goodsImgs);

        return ResultUtil.exec (true,"OK",vGoods);
    }

    @Override
    public ResultVo addGoods(Goods goods) {

        return ResultUtil.exec (goodsMapper.insert (goods) > 0,"OK",null);
    }

    @Override
    public void updateGoods(Goods goods) {

        ResultUtil.exec (goodsMapper.updateById (goods) > 0, "OK",null);
    }

    @Override
    public void deleteByGoodsId(int id) {

        ResultUtil.exec (goodsMapper.deleteById (id) > 0,"OK",null);
    }
}
