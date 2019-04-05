package com.li.bsk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.bsk.entity.GoodsClassifyDetails;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author li
 * @since 2019-03-25
 */
public interface GoodsClassifyDetailsMapper extends BaseMapper<GoodsClassifyDetails> {

    List<GoodsClassifyDetails> selectByGoodsId(int id);

}