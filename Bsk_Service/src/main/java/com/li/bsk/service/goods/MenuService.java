package com.li.bsk.service.goods;

import com.li.bsk.entity.Menu;

import java.lang.management.MemoryUsage;
import java.util.List;

public interface MenuService {

    List<Menu> selectByMenuLev(int level);
}
