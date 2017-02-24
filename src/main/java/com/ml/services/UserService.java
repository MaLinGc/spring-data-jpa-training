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

    public Page<User> findUsersByFilter(Filter filter, Pageable pageable) {
        return userRepository.findUsersByFilter(filter, pageable);
    }

    public User findOne(Long userId) {
        return userRepository.findOne(userId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public List<User> findUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
