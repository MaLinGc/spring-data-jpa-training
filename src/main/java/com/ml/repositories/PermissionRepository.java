package com.ml.repositories;

import com.ml.entities.Permission;
import com.ml.vo.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, String> {

    List<Permission> findByPermissionGroupGroupName(String name);

    Page<Permission> findByName(String name, Pageable pageable);

    List<Permission> findByFilter(Filter filter);
}
