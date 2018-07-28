package com.lwb.system.dao;

import com.lwb.system.domain.RoleMenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 角色与菜单对应关系
 * @author lwb
 * @email lwbldy@163.com
 * @date 2018-07-20 11:49:46
 */
@Mapper
@Repository
public interface RoleMenuDao {

	RoleMenuDO get(Long id);
	
	List<RoleMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int update(RoleMenuDO roleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	/**
	 * 根据roleid删除角色名称
	 * @param roleId
	 * @return
	 */
	int delByRoleId(Long roleId);

	/**
	 * 保存roleMenus
	 * @param map
	 */
	void saveRoleMenus(Map<String, Object> map);

	/**
	 * 根据角色id查询权限id
	 * @param roleId
	 * @return
	 */
	List<Integer> queryMenuIdList(long roleId);
}
