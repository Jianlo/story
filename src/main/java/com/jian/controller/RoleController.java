package com.jian.controller;

import com.jian.entity.Role;
import com.jian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Role> roles = roleService.queryAll();
        model.addAttribute("roles",roles);
        return "role";
    }
}
