package com.lwb.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.lwb.system.dao.UserRoleDao;
import com.lwb.system.domain.UserRoleDO;
import com.lwb.system.service.UserRoleService;



@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public UserRoleDO get(Long id){
		return userRoleDao.get(id);
	}
	
	@Override
	public List<UserRoleDO> list(Map<String, Object> map){
		return userRoleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userRoleDao.count(map);
	}
	
	@Override
	public int save(UserRoleDO userRole){
		return userRoleDao.save(userRole);
	}
	
	@Override
	public int update(UserRoleDO userRole){
		return userRoleDao.update(userRole);
	}
	
	@Override
	public int remove(Long id){
		return userRoleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userRoleDao.batchRemove(ids);
	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return userRoleDao.queryRoleIdList(userId);
	}

}
