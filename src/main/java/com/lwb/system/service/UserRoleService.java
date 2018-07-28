package com.lwb.system.service;

import com.lwb.system.domain.UserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * 
 * @author lwb
 * @email lwbldy@163.com
 * @date 2018-07-21 16:47:05
 */
public interface UserRoleService {
	
	UserRoleDO get(Long id);
	
	List<UserRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserRoleDO userRole);
	
	int update(UserRoleDO userRole);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}
