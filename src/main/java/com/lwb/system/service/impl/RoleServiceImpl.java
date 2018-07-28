package com.lwb.system.service.impl;

import com.lwb.common.util.Page;
import com.lwb.system.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lwb.system.dao.RoleDao;
import com.lwb.system.domain.RoleDO;
import com.lwb.system.service.RoleService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Resource
	private RoleMenuService roleMenuService;
	
	@Override
	public RoleDO get(Long roleId){
		return roleDao.get(roleId);
	}
	
	@Override
	public List<RoleDO> list(Map<String, Object> map){
		return roleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return roleDao.count(map);
	}
	
	@Override
	public int save(RoleDO role){
		return roleDao.save(role);
	}
	
	@Override
	public int update(RoleDO role){
		return roleDao.update(role);
	}
	
	@Override
	public int remove(Long roleId){
		return roleDao.remove(roleId);
	}
	
	@Override
	public int batchRemove(Long[] roleIds){
		return roleDao.batchRemove(roleIds);
	}

	@Override
	public Page<RoleDO> findByPage(Page<RoleDO> page) {
		page.setTotal(roleDao.pageCount(page));
		page.setRecords(roleDao.pageList(page));
		return page;
	}

	@Transactional
	public boolean insertRole(RoleDO role, String roleMenuIds) {
		//保存
		role.setGmtCreate(new Date());
		roleDao.save(role);

		//
		if(roleMenuIds == null || roleMenuIds.length() == 0)
			return true;
		String[] roleMenuIdsArr = roleMenuIds.split(",");
		List<Integer> roleMenuIdList = new ArrayList<Integer>();
		for (String menuId : roleMenuIdsArr){
			roleMenuIdList.add(Integer.parseInt(menuId));
		}
		//保存数据
		roleMenuService.saveOrUpdate(role.getRoleId(),roleMenuIdList);

		return true;
	}


	/**
	 * 保存角色权限
	 * @param role
	 * @param roleMenuIds
	 * @return
	 */
	@Transactional
	public boolean updateRole(RoleDO role, String roleMenuIds) {
		int resultRow = roleDao.update(role);
		if(resultRow == 1){
			String[] roleMenuIdsArr = roleMenuIds.split(",");
			if(roleMenuIds == null || roleMenuIds.length() == 0)
				return true;
			List<Integer> roleMenuIdList = new ArrayList<Integer>();
			for (String menuId : roleMenuIdsArr){
				roleMenuIdList.add(Integer.parseInt(menuId));
			}
			//保存数据
			roleMenuService.saveOrUpdate(role.getRoleId(),roleMenuIdList);
			return true;
		}
		return false;
	}
}
