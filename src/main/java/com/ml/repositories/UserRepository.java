package com.ml.repositories;

import com.ml.entities.User;
import com.ml.vo.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    List<User> findByNameContaining(String name);

    Page<User> findByFilter(Filter filter, Pageable pageable);

}
