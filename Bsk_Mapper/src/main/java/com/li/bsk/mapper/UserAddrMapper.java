package com.li.bsk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.bsk.entity.UserAddr;
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
public interface UserAddrMapper extends BaseMapper<UserAddr> {

    @Select ("select * from user_addr where user_id = #{id}")
    List<UserAddr> findByUserId(int id);

}