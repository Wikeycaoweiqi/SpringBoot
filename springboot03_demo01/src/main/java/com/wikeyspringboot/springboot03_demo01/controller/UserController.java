package com.wikeyspringboot.springboot03_demo01.controller;

import com.wikeyspringboot.springboot03_demo01.pojo.Result;
import com.wikeyspringboot.springboot03_demo01.pojo.User;
import com.wikeyspringboot.springboot03_demo01.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wikey
 * @create: 2024-07-10 23:00
 * @Description:
 */
@Validated
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "register")
    public Result register(@RequestParam("username") @Pattern(regexp = "^\\S{5,16}$") String username, @RequestParam("password") @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户
        User user = userService.findUserByUsername(username);
        if (user == null) {
            userService.registerUser(username, password);
            return Result.success();
        } else {
            return Result.error("username is already exists");
        }
    }
}