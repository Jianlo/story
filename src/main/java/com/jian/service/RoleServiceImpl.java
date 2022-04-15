package com.jian.service;

import com.jian.dao.RoleMapper;
import com.jian.entity.Role;
import lombok.Setter;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    @Setter
    private RoleMapper roleMapper;
    @Override
    public List<Role> queryAll() {
        return roleMapper.queryAll();
    }
}
