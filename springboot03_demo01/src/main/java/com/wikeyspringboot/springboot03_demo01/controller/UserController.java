package com.wikeyspringboot.springboot03_demo01.controller;

import com.wikeyspringboot.springboot03_demo01.pojo.Result;
import com.wikeyspringboot.springboot03_demo01.pojo.User;
import com.wikeyspringboot.springboot03_demo01.service.UserService;
import com.wikeyspringboot.springboot03_demo01.utils.JWTUtil;
import com.wikeyspringboot.springboot03_demo01.utils.MD5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-10 23:00
 * @Description: 用户控制器，负责处理用户注册和登录的请求
 */
@Validated
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    // 声明UserService的实例，用于访问用户服务
    private UserService userService;

    /**
     * 处理用户注册请求
     *
     * @param username 用户名，要求5-16个非空白字符
     * @param password 密码，要求5-16个非空白字符
     * @return 注册结果，成功返回空结果，失败返回错误信息
     */
    @PostMapping(value = "register")
    public Result register(
            @RequestParam("username") @Pattern(regexp = "^\\S{5,16}$") String username,
            @RequestParam("password") @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 检查用户名是否已存在
        User user = userService.findUserByUsername(username);
        if (user == null) {
            // 用户名不存在，执行注册操作，注册前对密码进行MD5加密
            userService.registerUser(username, MD5Util.md5(password));
            return Result.success();
        } else {
            // 用户名已存在，返回错误信息
            return Result.error("用户名已存在");
        }
    }

    /**
     * 处理用户登录请求
     *
     * @param username 用户名，要求5-16个非空白字符
     * @param password 密码，要求5-16个非空白字符
     * @return 登录结果，成功返回包含JWT令牌的Result对象，失败返回错误信息
     */
    @PostMapping(value = "login")
    public Result login(
            @RequestParam("username") @Pattern(regexp = "^\\S{5,16}$") String username,
            @RequestParam("password") @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 根据用户名查询用户信息
        User user = userService.findUserByUsername(username);
        if (user == null) {
            // 用户不存在，返回错误信息
            return Result.error("用户名不存在");
        }

        // 验证密码是否正确
        if (MD5Util.md5(password).equals(user.getPassword())) {
            // 密码正确，生成JWT令牌所需claims
            Map<String, Object> claims = new HashMap<>();
            // 将用户ID作为JWT令牌的声明
            claims.put("id", user.getId());

            // 生成JWT令牌
            String token = JWTUtil.generateToken(claims);

            // 返回包含JWT令牌的成功结果
            return Result.success(token);
        } else {
            // 密码错误，返回错误信息
            return Result.error("密码错误");
        }
    }
}