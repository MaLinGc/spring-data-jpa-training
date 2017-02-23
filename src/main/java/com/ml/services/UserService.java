package com.ml.services;

import com.ml.entities.User;
import com.ml.repositories.UserRepository;
import com.ml.vo.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findByNameLike(String name) {
        return userRepository.findByNameLike(name);
    }

    public List<User> findByNameContaining(String name) {
        return userRepository.findByNameContaining(name);
    }

    public Page<User> findByFilter(Filter filter, Pageable pageable) {
        return userRepository.findByFilter(filter, pageable);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
