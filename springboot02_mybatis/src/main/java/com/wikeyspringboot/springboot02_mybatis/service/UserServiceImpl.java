package com.wikeyspringboot.springboot02_mybatis.service;

import com.wikeyspringboot.springboot02_mybatis.mapper.UserMapper;
import com.wikeyspringboot.springboot02_mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wikey
 * @create: 2024-07-09 21:28
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}