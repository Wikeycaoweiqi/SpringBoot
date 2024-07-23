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
     * 注册新用户，将用户信息保存到数据库。
     * 密码在保存前应进行加密处理，以确保安全性。
     */
    void registerUser(String username, String password);

    /**
     * 更新用户信息
     *
     * @param user 用户实体，包含需要更新的字段
     * 更新用户的基本信息，如邮箱、昵称等。
     * 此方法不返回任何值，通常在操作完成后直接返回void。
     */
    void update(User user);

    /**
     * 更新用户头像
     *
     * @param avatarUrl 新头像的URL地址
     * 更新用户的头像信息。
     * 此方法不返回任何值，通常在操作完成后直接返回void。
     */
    void updateAvatar(String avatarUrl);

    /**
     * 更新用户密码
     *
     * @param username 用户名
     * @param new_pwd 新密码的MD5加密字符串
     * 更新用户的密码信息。
     * 此方法不返回任何值，通常在操作完成后直接返回void。
     */
    void updatePwd(String username, String new_pwd);
}