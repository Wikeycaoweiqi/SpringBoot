package com.wikeyspringboot.springboot02_mybatis.controller;

import com.wikeyspringboot.springboot02_mybatis.pojo.User;
import com.wikeyspringboot.springboot02_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wikey
 * @create: 2024-07-09 21:29
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }
}