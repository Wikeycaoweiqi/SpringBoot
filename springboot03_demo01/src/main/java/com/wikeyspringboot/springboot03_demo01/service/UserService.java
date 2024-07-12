package com.wikeyspringboot.springboot03_demo01.service;

import com.wikeyspringboot.springboot03_demo01.pojo.User;

public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 返回找到的用户实体，如果没有找到则返回null
     */
    User findUserByUsername(String username);

    /**
     * 注册新用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 注册成功返回操作结果，失败则返回错误信息
     */
    void registerUser(String username, String password);
}