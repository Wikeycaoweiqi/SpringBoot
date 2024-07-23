package com.wikeyspringboot.springboot03_demo01.service.impl;

import com.wikeyspringboot.springboot03_demo01.mapper.UserMapper;
import com.wikeyspringboot.springboot03_demo01.pojo.User;
import com.wikeyspringboot.springboot03_demo01.service.UserService;
import com.wikeyspringboot.springboot03_demo01.utils.MD5Util;
import com.wikeyspringboot.springboot03_demo01.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-10 23:02
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 返回找到的用户实体，如果没有找到则返回null
     */
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    /**
     * 注册新用户
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void registerUser(String username, String password) {
        userMapper.saveUser(username, password);
    }

    /**
     * 更新用户信息
     *
     * @param user 包含更新信息的用户对象
     */
    @Override
    public void update(User user) {
        userMapper.updateUser(user);
    }

    /**
     * 更新用户头像
     *
     * @param avatarUrl 新头像的URL地址
     */
    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        int id = (Integer) userMap.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    /**
     * 更新用户密码
     *
     * @param username 用户名
     * @param new_pwd  新密码的MD5加密字符串
     */
    @Override
    public void updatePwd(String username, String new_pwd) {
        userMapper.updatePwd(username, new_pwd);
    }
}