package com.ml.services;

import com.ml.commons.result.Result;
import com.ml.entities.User;
import com.ml.repositories.UserRepository;
import com.ml.vo.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findUsersByFilter(Filter filter, Pageable pageable) {
        return userRepository.findUsersByFilter(filter, pageable);
    }

    public User findUserById(Long userId) {
        return userRepository.findOne(userId);
    }

    public Result<String> addUser(User user) {
        userRepository.save(user);
        return new Result<>(true);
    }
}
