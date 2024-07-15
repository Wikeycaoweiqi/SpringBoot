package com.wikeyspringboot.springboot03_demo01.service.impl;

import com.wikeyspringboot.springboot03_demo01.mapper.UserMapper;
import com.wikeyspringboot.springboot03_demo01.pojo.User;
import com.wikeyspringboot.springboot03_demo01.service.UserService;
import com.wikeyspringboot.springboot03_demo01.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wikey
 * @create: 2024-07-10 23:02
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void registerUser(String username, String password) {
        userMapper.saveUser(username, password);
    }
}