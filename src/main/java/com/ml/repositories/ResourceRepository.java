package com.ml.repositories;

import com.ml.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResourceRepository extends JpaRepository<Resource, Long> {}
