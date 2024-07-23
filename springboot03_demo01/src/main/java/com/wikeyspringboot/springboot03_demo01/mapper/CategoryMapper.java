package com.wikeyspringboot.springboot03_demo01.mapper;

import com.wikeyspringboot.springboot03_demo01.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: wikey
 * @create: 2024-07-21 10:12
 * @Description:
 */
@Mapper
public interface CategoryMapper {

    /**
     * 根据ID查询类别
     *
     * @param id 类别的唯一标识符
     * @return 返回找到的类别对象，如果没有找到则返回null
     */
    @Select("SELECT * FROM CATEGORY WHERE CREATE_USER = #{ID}")
    List<Category> getCategoriesById(Integer id);

    /**
     * 插入新的类别
     *
     * @param category 包含新类别信息的实体对象
     * @return 插入操作的受影响行数
     */
    @Insert("INSERT INTO CATEGORY (CATEGORY_NAME, CATEGORY_ALIAS, CREATE_USER, CREATE_TIME, UPDATE_TIME) VALUES (#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);

    /**
     * 获取类别详情
     *
     * @param categoryId 类别的ID
     * @param userId     用户ID
     * @return 返回指定ID的类别对象
     */
    @Select("SELECT * FROM CATEGORY WHERE ID = #{categoryId} AND CREATE_USER = #{userId}")
    Category getCategoryDetailById(Integer categoryId, Integer userId);

    /**
     * 更新类别信息
     *
     * @param category 包含更新信息的类别实体对象
     */
    @Update("UPDATE CATEGORY SET CATEGORY_NAME = #{categoryName}, CATEGORY_ALIAS = #{categoryAlias}, UPDATE_TIME = #{updateTime} WHERE ID = #{id} AND CREATE_USER = #{createUser}")
    void update(Category category);

    /**
     * 删除类别
     *
     * @param category 包含要删除类别信息的实体对象
     */
    @Delete("DELETE FROM CATEGORY WHERE ID = #{id} AND CREATE_USER = #{createUser}")
    void delete(Category category);
}