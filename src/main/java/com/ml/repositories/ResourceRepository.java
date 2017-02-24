package com.ml.repositories;

import com.ml.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findUserResources(Long userId);
}
