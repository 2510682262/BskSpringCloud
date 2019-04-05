package com.li.bsk.provider.goods.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.util.TokenUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.vo.VShop;
import com.li.bsk.entity.Goods;
import com.li.bsk.entity.GoodsClassifyDetails;
import com.li.bsk.entity.Shop;
import com.li.bsk.mapper.GoodsClassifyDetailsMapper;
import com.li.bsk.mapper.GoodsMapper;
import com.li.bsk.mapper.ShopMapper;
import com.li.bsk.service.goods.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopProvider implements ShopService {

    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsClassifyDetailsMapper detailsMapper;

    @Override
    public ResultVo addShop(Shop shop, String toekn) {

        shop.setUserId (TokenUtil.parseToken (toekn));
        return ResultUtil.exec (shopMapper.insert (shop) > 0,"OK",null);
    }

    @Override
    public void updateShop(Shop shop) {

        shopMapper.updateById (shop);
    }

    @Override
    public void delShop(int id) {
        shopMapper.deleteById (id);
    }

    @Override
    public List<VShop> findByUserId(String token) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<Shop> ().eq ("user_id", TokenUtil.parseToken (token));
        List<Shop> shops = shopMapper.selectList (queryWrapper);
        List<VShop> vShops = new ArrayList<> ();
        for (Shop s: shops) {
            VShop shop = new VShop ();
            shop.setShopNum (s.getShopNum ());
            shop.setShopId (TokenUtil.parseToken (token));
            shop.setShopTotalprice (s.getShopTotalprice ());
            Goods goods = goodsMapper.selectById (s.getGoodsId ());
            GoodsClassifyDetails goodsClassifyDetails = detailsMapper.selectById (s.getClassifyId ());
            shop.setGoods (goods);
            shop.setGoodsClassifyDetails (goodsClassifyDetails);
            vShops.add (shop);
        }
        return vShops;
    }
}
