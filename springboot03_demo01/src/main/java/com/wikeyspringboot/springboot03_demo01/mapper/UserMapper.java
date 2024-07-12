package com.wikeyspringboot.springboot03_demo01.mapper;

import com.wikeyspringboot.springboot03_demo01.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findUserByUsername(String username);

    /**
     * 保存新用户到数据库。
     *
     * @param username    用户名，需要保存到数据库的新用户的用户名。
     * @param md5Password 用户的MD5加密后的密码。
     * @return 通常void方法没有返回值，但在某些情况下，可以返回一个表示操作成功或失败的布尔值。
     */
    @Insert("INSERT INTO user (username, password, create_time, update_time) VALUES (#{username}, #{password}, now(), now())")
    void saveUser(String username, String password);
}