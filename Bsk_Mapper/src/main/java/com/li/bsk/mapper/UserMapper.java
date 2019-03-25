package com.li.bsk.mapper;

import com.li.bsk.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author li
 * @since 2019-03-25
 */
public interface UserMapper extends BaseMapper<User> {

    @Select ("select * from user where user_name = #{name}")
    User selectByName(String name);

}