package com.lwb.system.service;


import com.lwb.system.domain.MenuDO;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理 服务类
 */
public interface MenuService {

    MenuDO get(Long menuId);

    List<MenuDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MenuDO menu);

    int update(MenuDO menu);

    int remove(Long menuId);

    int batchRemove(Long[] menuIds);

    List<MenuDO> findMenuByUserId(Long userId);

    /**
     * 查询所有菜单(包含pname)
     * @return
     */
    List<MenuDO> queryMenuAll();

}
