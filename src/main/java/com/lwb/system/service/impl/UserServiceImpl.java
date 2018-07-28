package com.lwb.system.service.impl;

import com.lwb.common.dao.GeneratorMapper;
import com.lwb.common.util.Page;
import com.lwb.system.dao.UserDao;
import com.lwb.system.dao.UserRoleDao;
import com.lwb.system.domain.UserDO;
import com.lwb.system.domain.UserRoleDO;
import com.lwb.system.service.UserRoleService;
import com.lwb.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserDao userMapper;
    @Resource
    UserRoleDao userRoleDao;

    @Override
    @Cacheable(value = "myCache", key = "'user_'+#id")
    public UserDO get(Long id) {
        System.out.println("--------------->>id-->"+id);
        UserDO userDO = userMapper.get(id);

        return userDO;
    }

    @CacheEvict(value = "myCache", key = "'user_'+#id")
    public void modifyUser(Long id) {
        System.out.println("删除id为-->"+id+"的缓存");
    }

    @Override
    public Page findByPage(Page page) {
        page.setRecords(userMapper.pageList(page));
        page.setTotal(userMapper.pageCount(page));
        return page;
    }

    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userMapper.count(map);
    }

    @Override
    @Transactional
    public int save(UserDO user) {

        user.setGmtCreate(new Date());
        user.setGmtModified(user.getGmtCreate());

        int count = userMapper.save(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getRoleIds();
        userRoleDao.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleDao.batchSave(list);
        }
        return count;
    }

    @Override
    @Transactional
    public int update(UserDO user) {

        int r = userMapper.update(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getRoleIds();
        userRoleDao.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleDao.batchSave(list);
        }
        return r;
    }

    @Override
    public int remove(Long userId) {
        return userMapper.remove(userId);
    }

    @Override
    public int batchremove(Long[] userIds) {
        return userMapper.batchRemove(userIds);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        return false;
    }

    @Override
    public Set<String> listRoles(Long userId) {
        return null;
    }

    @Override
    public int updatePersonal(UserDO userDO) {
        return 0;
    }

    @Override
    public Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception {
        return null;
    }
}
