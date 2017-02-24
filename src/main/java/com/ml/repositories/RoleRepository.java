package com.ml.repositories;

import com.ml.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findRoleByUserId(Long userId);
}
