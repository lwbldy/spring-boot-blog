package com.lwb.system.service;

import com.lwb.system.domain.RoleMenuDO;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * 
 * @author lwb
 * @email lwbldy@163.com
 * @date 2018-07-20 11:49:46
 */
public interface RoleMenuService {
	
	RoleMenuDO get(Long id);
	
	List<RoleMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int update(RoleMenuDO roleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	/**
	 * 保存或更新 角色权限
	 * @param roleId
	 * @param menuIdList
	 */
	void saveOrUpdate(Long roleId, List<Integer> menuIdList);

	/**
	 * 根据角色ID，获取菜单ID列表
	 * @param roleId
	 * @return
	 */
	List<Integer> queryMenuIdList(long roleId);

}
