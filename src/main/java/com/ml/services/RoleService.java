package com.ml.services;

import com.ml.entities.Role;
import com.ml.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findOne(Long id) {
        return roleRepository.findOne(id);
    }

    public List<Role> findRoleByUserId(Long userId) {
        return roleRepository.findRoleByUserId(userId);
    }
}
