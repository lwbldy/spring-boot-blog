package com.lwb.system.dao;

import com.lwb.system.domain.UserRoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户与角色对应关系
 * @author lwb
 * @email lwbldy@163.com
 * @date 2018-07-21 16:47:05
 */
@Mapper
@Repository
public interface UserRoleDao {

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

	/**
	 * 根据user获取角色
	 * @param userId
	 * @return
	 */
	int removeByUserId(Long userId);

	/**
	 * 根据权限id获取角色
	 * @param roleId
	 * @return
	 */
	int removeByRoleId(Long roleId);

	/**
	 * 批量保存用户角色
	 * @param list
	 * @return
	 */
	int batchSave(List<UserRoleDO> list);
}
