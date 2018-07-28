package com.lwb.system.controller;

import com.lwb.system.domain.MenuDO;
import com.lwb.system.domain.UserDO;
import com.lwb.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统控制器
 */

@Controller
@RequestMapping("/sys")
public class SystemController {


    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "/system/index";
    }


}