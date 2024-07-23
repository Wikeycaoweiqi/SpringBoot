package com.wikeyspringboot.springboot03_demo01.service;

import com.wikeyspringboot.springboot03_demo01.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 添加新类别
     *
     * @param category 要添加的新类别对象
     */
    void add(Category category);

    /**
     * 获取所有类别列表
     *
     * @return 返回所有类别的列表
     */
    List<Category> list();

    /**
     * 获取类别详情
     *
     * @param id 类别的ID
     * @return 返回指定ID的类别对象
     */
    Category detail(Integer id);

    /**
     * 更新类别信息
     *
     * @param category 包含更新信息的类别对象
     */
    void update(Category category);

    /**
     * 删除类别
     *
     * @param category 包含要删除类别信息的对象
     */
    void delete(Category category);
}