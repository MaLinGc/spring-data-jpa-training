package com.ml.repositories;

import com.ml.entities.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysLogRepository extends JpaRepository<SysLog, Long> {}
