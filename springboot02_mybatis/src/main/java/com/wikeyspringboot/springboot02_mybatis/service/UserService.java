package com.wikeyspringboot.springboot02_mybatis.service;

import com.wikeyspringboot.springboot02_mybatis.pojo.User;

public interface UserService {

    User findById(Integer id);
}