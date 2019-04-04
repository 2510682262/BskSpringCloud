package com.li.bsk.provider.goods.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.bsk.entity.Menu;
import com.li.bsk.entity.User;
import com.li.bsk.mapper.MenuMapper;
import com.li.bsk.service.goods.MenuService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuProvider implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectByMenuLev(int level) {

        QueryWrapper<Menu> queryWrapper = new QueryWrapper<Menu> ().eq ("menu_level",level);
        return menuMapper.selectList (queryWrapper);
    }
}
