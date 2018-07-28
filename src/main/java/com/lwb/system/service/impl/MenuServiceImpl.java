package com.lwb.system.service.impl;

import com.lwb.system.dao.MenuDao;
import com.lwb.system.domain.MenuDO;
import com.lwb.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理 服务实现类
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public MenuDO get(Long menuId) {
        return menuDao.get(menuId);
    }

    @Override
    public List<MenuDO> list(Map<String, Object> map) {
        return menuDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return menuDao.count(map);
    }

    @Override
    public int save(MenuDO menu) {
        return menuDao.save(menu);
    }

    @Override
    public int update(MenuDO menu) {
        return menuDao.update(menu);
    }

    @Override
    public int remove(Long menuId) {
        return menuDao.remove(menuId);
    }

    @Override
    public int batchRemove(Long[] menuIds) {
        return menuDao.batchRemove(menuIds);
    }

    @Override
    public List<MenuDO> findMenuByUserId(Long userId) {
        return menuDao.selectMenuByUserId(userId);
    }

    @Override
    public List<MenuDO> queryMenuAll() {
//        Map<String,Object> paramMap = new HashMap<String ,Object>();
//        paramMap.put("sort","menu_id");
        return menuDao.queryList(null);
    }
}
