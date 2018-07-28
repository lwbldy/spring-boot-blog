package com.lwb.system.dao;

import com.lwb.common.util.Page;
import com.lwb.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 角色
 * @author lwb
 * @email lwbldy@163.com
 * @date 2018-07-20 11:49:45
 */
@Mapper
@Repository
public interface RoleDao {

	RoleDO get(Long roleId);
	
	List<RoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(Long role_id);
	
	int batchRemove(Long[] roleIds);

	List<RoleDO> pageList(Page<RoleDO> page);

	int pageCount(Page<RoleDO> page);

}
