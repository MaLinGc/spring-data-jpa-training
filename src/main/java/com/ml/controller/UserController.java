package com.ml.controller;

import com.ml.commons.base.BaseController;
import com.ml.entities.User;
import com.ml.services.UserService;
import com.ml.vo.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/u")
public class UserController extends BaseController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/list")
    public Page<User> list(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping(path = "/findByName")
    public List<User> find(String name) {

        return userService.findByName(name);
    }

    @GetMapping(path = "/findByNameLike")
    public List<User> findByNameLike(String name) {
        return userService.findByNameLike(name);
    }

    @GetMapping(path = "/findByNameContaining")
    public List<User> findByNameContaining(String name) {
        return userService.findByNameContaining(name);
    }

    @GetMapping(path = "/findByFilter")
    public Page<User> findByFilter(Filter filter, Pageable pageable) {
        return userService.findByFilter(filter, pageable);
    }

    @PostMapping(path = "/add")
    public User add(User user) {
        user.setId("1");
        user.setCreateTime(new Date());
        return userService.addUser(user);
    }
}
