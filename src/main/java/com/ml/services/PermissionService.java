package com.ml.services;

import com.ml.entities.Permission;
import com.ml.repositories.PermissionRepository;
import com.ml.vo.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Page<Permission> findByName(String name, Pageable pageable) {
        return permissionRepository.findByName(name, pageable);
    }

    public List<Permission> findByPermissionGroupGroupName(String name) {
        return permissionRepository.findByPermissionGroupGroupName(name);
    }

    public List<Permission> findByFilter(Filter filter) {
        return permissionRepository.findByFilter(filter);
    }

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
