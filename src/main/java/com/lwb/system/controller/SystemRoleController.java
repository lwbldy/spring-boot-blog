package com.lwb.system.controller;

import com.lwb.common.util.Page;
import com.lwb.common.util.PageLayUI;
import com.lwb.common.util.R;
import com.lwb.system.domain.RoleDO;
import com.lwb.system.service.RoleMenuService;
import com.lwb.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/role")
public class SystemRoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    RoleMenuService roleMenuService;

    @RequestMapping(value = {"/","/list"},method = RequestMethod.GET)
    public String list(){
        return "/system/role/list";
    }


    /**
     * 分页查询用户
     * @param page
     * @return
     */
    @RequestMapping(value = "page")
    @ResponseBody
    public Object page(Page<RoleDO> page){
        Page resultPage = roleService.findByPage(page);
        return new PageLayUI(resultPage);
    }

    /**
     * 增加角色
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String toAdd(){
        return "/system/role/add";
    }


    /**
     * 增加角色
     * @param role
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public R add(RoleDO role, String roleMenuIds){
        if(roleService.insertRole(role,roleMenuIds))
            return R.ok();
        else return R.error();
    }

    /**
     * 跳转到更新页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id")long id, ModelMap map){
        map.put("id",id);
        return "/system/role/edit";
    }

    /**
     * 根据ID来更新
     * @param role
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public R update(RoleDO role,String roleMenuIds){

        if(roleService.updateRole(role,roleMenuIds)){
            return R.ok();
        }else
            return R.error();
    }

    @RequestMapping(value = "findById/{id}")
    @ResponseBody
    public RoleDO findById(@PathVariable("id")long id,ModelMap map){
        RoleDO role = roleService.get(id);
        //获取权限列表
        role.setMenuIdList(roleMenuService.queryMenuIdList(id));
        return role;
    }

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping(value = "findAll")
    @ResponseBody
    public List<RoleDO> findAll(){
        return roleService.list(null);
    }

}
