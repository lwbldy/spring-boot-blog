package com.lwb.system.service;

import com.lwb.common.util.Page;
import com.lwb.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * 
 * @author lwb
 * @email lwbldy@163.com
 * @date 2018-07-20 11:49:45
 */
public interface RoleService {
	
	RoleDO get(Long roleId);
	
	List<RoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(Long roleId);
	
	int batchRemove(Long[] roleIds);

	Page<RoleDO> findByPage(Page<RoleDO> page);


	/**
	 * 保存角色
	 * @param role 角色信息
	 * @param roleMenuIds 对应的菜单
	 * @return
	 */
	boolean insertRole(RoleDO role, String roleMenuIds);

	/**
	 * 更新角色信息
	 * @param role
	 * @param roleMenuIds
	 * @return
	 */
	boolean updateRole(RoleDO role, String roleMenuIds);
}
