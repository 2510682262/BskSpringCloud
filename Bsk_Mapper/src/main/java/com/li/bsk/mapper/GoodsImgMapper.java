package com.li.bsk.mapper;

import com.li.bsk.entity.GoodsImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author li
 * @since 2019-03-25
 */
public interface GoodsImgMapper extends BaseMapper<GoodsImg> {

    @Select ("select * from goods_img where goods_id = #{id}")
    List<GoodsImg> selectByGoodsId(int id);

}