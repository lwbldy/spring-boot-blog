package com.lwb.system.controller;

import com.lwb.common.util.MD5Utils;
import com.lwb.common.util.Page;
import com.lwb.common.util.PageLayUI;
import com.lwb.common.util.R;
import com.lwb.system.domain.UserDO;
import com.lwb.system.service.UserRoleService;
import com.lwb.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sys/user")
public class SystemUserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = {"","/","list"})
    public String userList(){
        return "/system/user/list";
    }

    /**
     * 分页查询用户
     * @param page
     * @return
     */
    @RequestMapping(value = "page")
    @ResponseBody
    public Object findByPage(Page<UserDO> page){
        Page resultPage = userService.findByPage(page);
        return new PageLayUI(resultPage);
    }

    @RequestMapping(value = "findById/{userId}")
    @ResponseBody
    public UserDO findById(@PathVariable("userId")long userId){

        UserDO user = userService.get(userId);
        //获取用户所属的角色列表
        List<Long> roleIdList = userRoleService.queryRoleIdList(userId);
        user.setRoleIds(roleIdList);
        return user;
    }

    /**
     * 跳转到更新
     * @return
     */
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") long id, ModelMap map){
        map.put("id",id);
        return "/system/user/edit";
    }

    /**
     * 根据角色
     * @param user
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public R update(UserDO user){
        if (userService.update(user) == 1)
            return R.ok();
        else return R.error();
    }


    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String toAdd(){
        return "/system/user/add";
    }

    /**
     * 增加角色
     * @param user
     * @return
     */
    @PostMapping(value = "add")
    @ResponseBody
    public R add(UserDO user){
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        if(userService.save(user) == 1)
            return R.ok();
        else return R.error();
    }

    /**
     * 根据 id 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "del/{id}")
    @ResponseBody
    public R delById(@PathVariable("id")long id){
        if(userService.remove(id) == 1){
            return R.ok();
        }else{
            return R.error();
        }
    }

}
