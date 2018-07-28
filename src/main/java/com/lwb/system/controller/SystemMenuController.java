package com.lwb.system.controller;


import com.lwb.common.util.R;
import com.lwb.system.domain.MenuDO;
import com.lwb.system.domain.UserDO;
import com.lwb.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/menu")
public class SystemMenuController {

    @Autowired
    MenuService menuService;

    /**
     * 获取左侧菜单栏
     * @return
     */
    @RequestMapping(value = "/findMenu")
    @ResponseBody
    public List<MenuDO> findMenu(){
        UserDO sysUser = (UserDO) SecurityUtils.getSubject().getPrincipal();
        return menuService.findMenuByUserId(sysUser.getUserId());
    }


    /**
     * 菜单首页
     * @return
     */
    @RequestMapping(value = "/")
    public String list(){
        return "/system/menu/list";
    }


    /**
     * 获取所有菜单
     * @return
     */
    @RequestMapping(value = "fundAll")
    @ResponseBody
//    @RequiresPermissions("sys:role:select") //详细参考  http://blog.csdn.net/w_stronger/article/details/73109248
    public List<MenuDO> fundAll(){
        return menuService.queryMenuAll();
    }


    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String toAdd(){
        return "/system/menu/add";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public R add(MenuDO sysMenu){
        if(menuService.save(sysMenu) == 1)
            return R.ok();
        else
            return R.error();
    }


    /**
     * 根据id 查询
     * @param id
     * @return
     */
    @RequestMapping(value = "findById/{id}")
    @ResponseBody
    public MenuDO findById(@PathVariable("id")long id){
        return menuService.get(id);
    }

    /**
     * 更新
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "update/{id}")
    public String toUpdate(@PathVariable("id")long id, ModelMap map){
        map.put("id",id);
        return "/system/menu/edit";
    }


    /**
     * 修改详细内容
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public R update(MenuDO sysMenu){
        if(menuService.update(sysMenu) == 1)
            return R.ok();
        else return R.error();
    }

}
