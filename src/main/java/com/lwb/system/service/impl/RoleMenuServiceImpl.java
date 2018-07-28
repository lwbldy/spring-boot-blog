package com.lwb.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lwb.system.dao.RoleMenuDao;
import com.lwb.system.domain.RoleMenuDO;
import com.lwb.system.service.RoleMenuService;



@Service
public class RoleMenuServiceImpl implements RoleMenuService {
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Override
	public RoleMenuDO get(Long id){
		return roleMenuDao.get(id);
	}
	
	@Override
	public List<RoleMenuDO> list(Map<String, Object> map){
		return roleMenuDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return roleMenuDao.count(map);
	}
	
	@Override
	public int save(RoleMenuDO roleMenu){
		return roleMenuDao.save(roleMenu);
	}
	
	@Override
	public int update(RoleMenuDO roleMenu){
		return roleMenuDao.update(roleMenu);
	}
	
	@Override
	public int remove(Long id){
		return roleMenuDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return roleMenuDao.batchRemove(ids);
	}

	@Override
	public void saveOrUpdate(Long roleId, List<Integer> menuIdList) {
		//先删除角色与菜单关系

		roleMenuDao.delByRoleId(roleId);

		if(menuIdList.size() == 0){
			return ;
		}

		//保存角色与菜单关系
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);
		map.put("menuIdList", menuIdList);
		roleMenuDao.saveRoleMenus(map);
	}

	@Override
	public List<Integer> queryMenuIdList(long roleId) {
		return roleMenuDao.queryMenuIdList(roleId);
	}

}
