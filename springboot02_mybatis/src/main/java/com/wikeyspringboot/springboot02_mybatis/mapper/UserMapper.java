package com.wikeyspringboot.springboot02_mybatis.mapper;

import com.wikeyspringboot.springboot02_mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // 根据ID查询用户信息
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);
}