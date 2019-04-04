package com.li.bsk.provider.goods.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsImg;
import com.li.bsk.mapper.GoodsClassifyDetailsMapper;
import com.li.bsk.mapper.GoodsImgMapper;
import com.li.bsk.mapper.GoodsMapper;
import com.li.bsk.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsProvider implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsImgMapper goodsImgMapper;
    @Autowired
    private GoodsClassifyDetailsMapper goodsClassifyDetailsMapper;

    @Override
    public Goods findByGoodsId(int id) {

        Goods goods = goodsMapper.selectById (id);
        return goods;
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

    @Override
    public List<GoodsImg> selectByGoodsId(int id) {
        QueryWrapper<GoodsImg> queryWrapper = new QueryWrapper<GoodsImg> ().eq ("goods_id", id);
        List<GoodsImg> goodsImgs = goodsImgMapper.selectList (queryWrapper);
        return goodsImgs;
    }

    @Override
    public List<Goods> selectByGoodsType(int type) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<> ();
        queryWrapper.eq ("goods_type",type);
        return goodsMapper.selectList (queryWrapper);
    }

    @Override
    public List<Goods> selectByGoodsGenre(int genre) {
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<> ();
        goodsQueryWrapper.eq ("goods_genre",genre);
        return goodsMapper.selectList (goodsQueryWrapper);
    }

}
