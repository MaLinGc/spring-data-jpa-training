package com.ml.controller;

import com.ml.commons.base.BaseController;
import com.ml.entities.Permission;
import com.ml.services.PermissionService;
import com.ml.vo.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/p")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/list")
    public List<Permission> list() {
        return permissionService.findAll();
    }

    @GetMapping("/find")
    public Page<Permission> find(String name, Pageable pageable) {
        return permissionService.findByName(name, pageable);
    }

    @GetMapping("/findPage")
    public Page<Permission> findPage(String name, Pageable pageable) {
        return permissionService.findByName(name, pageable);
    }

    @GetMapping("/findByPermissionGroupGroupName")
    public List<Permission> findByPermissionGroupGroupName(String name) {
        return permissionService.findByPermissionGroupGroupName(name);
    }

    @GetMapping("/findByFilter")
    public List<Permission> findByFilter(Filter filter) {
        return permissionService.findByFilter(filter);
    }
}
