package com.ml.controller;

import com.ml.commons.base.BaseController;
import com.ml.commons.result.Result;
import com.ml.entities.User;
import com.ml.services.UserService;
import com.ml.vo.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/u")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/list")
    public String users() {
        return "user/user_list" ;
    }

    @GetMapping(path = "/users")
    @ResponseBody
    public Page<User> users(Filter filter, Pageable pageable) {
        return userService.findUsersByFilter(filter, pageable);
    }

    @GetMapping(path = "/{userId}")
    @ResponseBody
    public User user(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @PostMapping(path = "/addUser")
    @ResponseBody
    public Result<String> addUser(User user) {
        return userService.addUser(user);
    }

}
