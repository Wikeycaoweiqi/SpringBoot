package com.wikeyspringboot.springboot03_demo01.controller;

import com.wikeyspringboot.springboot03_demo01.pojo.Result;
import com.wikeyspringboot.springboot03_demo01.pojo.User;
import com.wikeyspringboot.springboot03_demo01.service.UserService;
import com.wikeyspringboot.springboot03_demo01.utils.JWTUtil;
import com.wikeyspringboot.springboot03_demo01.utils.MD5Util;
import com.wikeyspringboot.springboot03_demo01.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-10 23:00
 * @Description:
 */
@Validated
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "register")
    public Result register(@RequestParam("username") @Pattern(regexp = "^\\S{5,16}$") String username, @RequestParam("password") @Pattern(regexp = "^\\S{5,16}$") String password) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            userService.registerUser(username, password);
            return Result.success();
        } else {
            return Result.error("username is already exists");
        }
    }

    /**
     * 处理用户登录请求的控制器方法。
     *
     * @param username 用户名，通过@RequestParam绑定请求参数，使用@Pattern注解限定用户名长度和字符要求。
     * @param password 密码，通过@RequestParam绑定请求参数，使用@Pattern注解限定密码长度和字符要求。
     * @return 登录结果，如果登录成功则返回包含JWT令牌的Result对象，失败则返回错误信息。
     */
    @PostMapping(value = "login")
    public Result login(@RequestParam("username") @Pattern(regexp = "^\\S{5,16}$") String username, @RequestParam("password") @Pattern(regexp = "^\\S{5,16}$") String password) {

        // 根据用户名查询用户
        User user = userService.findUserByUsername(username);

        // 如果用户不存在，返回错误信息
        if (user == null) {
            return Result.error("username is not exists");
        }

        // 如果用户名存在，验证密码是否正确
        // 使用MD5Util工具类对输入密码进行MD5加密，并与数据库中存储的密码进行比较
        if (MD5Util.md5(password).equals(user.getPassword())) {
            // 创建claims，包含JWT需要的声明
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId()); // 通常包含用户的唯一标识，如用户ID
            // 注意：密码不应该包含在JWT令牌的claims中，这可能是示例代码的简化或错误
            claims.put("username", user.getUsername()); // 这行代码在实际应用中应该被删除或替换

            // 使用JWTUtil工具类生成JWT令牌
            String token = JWTUtil.generateToken(claims);

            // 返回包含JWT令牌的成功结果
            return Result.success(token);
        }

        // 如果密码错误，返回错误信息
        return Result.error("password is wrong");
    }

    /**
     * 获取当前登录用户的信息
     *
     * @return Result对象，包含用户信息或错误信息
     */
    @GetMapping(value = "userInfo")
    public Result<User> userInfo() {
        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        String username = (String) userMap.get("username");
        User user = userService.findUserByUsername(username);
        return Result.success(user);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户对象，包含需要更新的信息，使用@RequestBody注解绑定请求体
     * @return Result对象，成功返回空结果，失败返回错误信息
     */
    @PutMapping(value = "update")
    public Result update(@RequestBody @Validated User user) {
        user.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        userService.update(user);
        return Result.success();
    }

    /**
     * 更新用户头像
     *
     * @param avatarUrl 新头像的URL地址，使用@RequestParam获取请求参数
     * @return Result对象，成功返回空结果，失败返回错误信息
     */
    @PatchMapping(value = "updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    /**
     * 更新用户密码
     *
     * @param params 包含旧密码、新密码和重复新密码的Map对象，使用@RequestBody注解绑定请求体
     * @return Result对象，成功返回更新成功提示，失败返回错误信息
     */
    @PatchMapping(value = "updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        String old_pwd = params.get("old_pwd");
        String new_pwd = params.get("new_pwd");
        String re_pwd = params.get("re_pwd");

        if (StringUtils.isEmpty(old_pwd) || StringUtils.isEmpty(new_pwd) || StringUtils.isEmpty(re_pwd)) {
            return Result.error("Please enter the password");
        }

        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        String username = (String) userMap.get("username");
        User user = userService.findUserByUsername(username);
        if (!MD5Util.md5(old_pwd).equals(user.getPassword())) {
            return Result.error("Old password is wrong");
        }

        if (!new_pwd.equals(re_pwd)) {
            return Result.error("New password is difference");
        }

        userService.updatePwd(username, MD5Util.md5(new_pwd));
        return Result.success("Successfully update password");
    }
}