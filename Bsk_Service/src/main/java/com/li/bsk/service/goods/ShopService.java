package com.li.bsk.service.goods;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.common.vo.VShop;
import com.li.bsk.entity.Shop;

import java.util.List;

public interface ShopService {

    ResultVo addShop(Shop shop, String token);

    void updateShop(Shop shop);

    void delShop(int id);

    List<VShop> findByUserId(String token);
}
