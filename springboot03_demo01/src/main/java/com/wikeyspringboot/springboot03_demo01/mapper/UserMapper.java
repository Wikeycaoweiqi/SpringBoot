package com.wikeyspringboot.springboot03_demo01.mapper;

import com.wikeyspringboot.springboot03_demo01.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: wikey
 * @create: 2024-07-10 23:01
 * @Description:
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户。
     *
     * @param username 用户名，用于在数据库中搜索对应的用户记录。
     * @return 返回找到的用户对象，如果未找到则可能返回null或抛出异常。
     */
    @Select("SELECT * FROM USER WHERE USERNAME = #{username}")
    User findUserByUsername(String username);

    /**
     * 保存新用户到数据库。
     *
     * @param username    用户名，需要保存到数据库的新用户的用户名。
     * @param password 用户的MD5加密后的密码。
     */
    @Insert("INSERT INTO USER (USERNAME, PASSWORD, CREATE_TIME, UPDATE_TIME) VALUES (#{username}, #{password}, NOW(), NOW())")
    void saveUser(String username, String password);

    /**
     * 更新用户信息
     *
     * @param user 包含用户新信息的实体对象
     */
    @Update("UPDATE USER SET EMAIL = #{email}, NICKNAME = #{nickname}, UPDATE_TIME = #{updateTime} WHERE ID = #{id}")
    void updateUser(User user);

    /**
     * 更新用户头像
     *
     * @param avatarUrl 新头像的URL地址
     * @param id 用户ID
     */
    @Update("UPDATE USER SET USER_PIC = #{avatarUrl}, UPDATE_TIME = NOW() WHERE ID = #{id}")
    void updateAvatar(String avatarUrl, int id);

    /**
     * 更新用户密码
     *
     * @param username 用户名
     * @param new_pwd 新密码的MD5加密字符串
     */
    @Update("UPDATE USER SET PASSWORD = #{new_pwd}, UPDATE_TIME = NOW() WHERE USERNAME = #{username}")
    void updatePwd(String username, String new_pwd);
}