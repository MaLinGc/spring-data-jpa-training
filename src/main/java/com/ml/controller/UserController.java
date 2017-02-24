package com.ml.controller;

import com.ml.commons.result.Result;
import com.ml.entities.User;
import com.ml.services.UserService;
import com.ml.vo.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/manager")
    public String users() {
        return "user/user";
    }

    @GetMapping(path = "/list")
    @ResponseBody
    public Page<User> users(Filter filter, Pageable pageable) {
        return userService.findUsersByFilter(filter, pageable);
    }

    @GetMapping(path = "/addPage")
    public String addPage() {
        return "user/add";
    }

    @GetMapping(path = "/editPage")
    public String editPage(Model model, Long id) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public Result<String> add(User user) {
        userService.save(user);
        return new Result<>(true);
    }

    @PostMapping(path = "/edit")
    @ResponseBody
    public Result<String> edit(User user) {
        userService.save(user);
        return new Result<>(true);
    }

    @PostMapping(path = "/delete")
    @ResponseBody
    public Result<String> delete(Long id) {
        userService.delete(id);
        return new Result<>(true);
    }
}
