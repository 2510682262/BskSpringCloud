package com.li.bsk.provider.goods.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsClassifyDetails;
import com.li.bsk.entity.GoodsImg;
import com.li.bsk.entity.Orderform;
import com.li.bsk.mapper.GoodsClassifyDetailsMapper;
import com.li.bsk.mapper.GoodsImgMapper;
import com.li.bsk.mapper.GoodsMapper;
import com.li.bsk.mapper.OrderformMapper;
import com.li.bsk.service.goods.GoodsService;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsProvider implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsImgMapper goodsImgMapper;
    @Autowired
    private GoodsClassifyDetailsMapper goodsClassifyDetailsMapper;
    @Autowired
    private OrderformMapper orderformMapper;

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

    @Override
    public List<GoodsClassifyDetails> findGoodsId(int id) {
        List<GoodsClassifyDetails> goodsClassifyDetails = goodsClassifyDetailsMapper.selectByGoodsId (id);
        for (GoodsClassifyDetails g: goodsClassifyDetails) {
            System.err.println (g.getDetailsName ());
        }
        return goodsClassifyDetails;
    }

    @Override
    public IPage<Goods> selectByMenuId(int menuId, int page, int limit) {
        QueryWrapper<Goods> eq = new QueryWrapper<Goods> ().eq ("goods_type", menuId).or ().eq ("goods_genre", menuId);
        Page<Goods> goodsPage = new Page<> (page, limit);
        
        return goodsMapper.selectPage (goodsPage,eq);
    }

    @Override
    public IPage<Orderform> selectByGoodsIdInOrder(String token, int page, int limit) {
        return orderformMapper.selectPage (new Page<> (page,limit),new QueryWrapper<Orderform> ().eq ("user_id", TokenUtil.parseToken (token)));
    }

    @Override
    public ResultVo addOrderform(Orderform orderform) {
        System.out.println ("goods_id" + orderform.getGoodsId ());
        Goods goods = goodsMapper.selectById (orderform.getGoodsId ());
        try {
            Integer goodsSalesvolume = goods.getGoodsSalesvolume ();
            goods.setGoodsSalesvolume (goods.getGoodsSalesvolume () + 1);
        } catch (Exception e) {
            e.printStackTrace ();
            goods.setGoodsSalesvolume (1);
        }
        goodsMapper.updateById (goods);
        orderform.setOrderDelivetime (new Date ());
        return ResultUtil.exec (orderformMapper.insert (orderform) > 0,"OK",null);
    }

    @Override
    public Integer selectGoodsCount() {
        return goodsMapper.selectCount (new QueryWrapper<Goods> ().isNotNull ("goods_id"));
    }

}
