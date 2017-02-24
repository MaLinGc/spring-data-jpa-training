package com.ml.services;

import com.ml.base.BaseServiceTest;
import com.ml.entities.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceTest extends BaseServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void findRoleByUserId() throws Exception {

        List<Role> roles = roleService.findRoleByUserId(1L);
        for (Role role : roles) {
            System.out.println(role.getName());
        }
    }

}