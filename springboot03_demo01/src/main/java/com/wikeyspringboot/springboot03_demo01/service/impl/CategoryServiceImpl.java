package com.wikeyspringboot.springboot03_demo01.service.impl;

import com.wikeyspringboot.springboot03_demo01.mapper.CategoryMapper;
import com.wikeyspringboot.springboot03_demo01.pojo.Category;
import com.wikeyspringboot.springboot03_demo01.service.CategoryService;
import com.wikeyspringboot.springboot03_demo01.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-21 10:11
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 获取所有类别列表
     *
     * @return 返回所有类别的列表
     */
    @Override
    public List<Category> list() {
        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        Integer id = (Integer) userMap.get("id");
        List<Category> categoryList = categoryMapper.getCategoriesById(id);
        return categoryList;
    }

    /**
     * 添加新类别
     *
     * @param category 要添加的新类别对象
     */
    @Override
    public void add(Category category) {
        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        category.setCreateUser((Integer) userMap.get("id"));
        category.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        category.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        categoryMapper.add(category);
    }

    /**
     * 获取类别详情
     *
     * @param categoryId 类别的ID
     * @return 返回指定ID的类别对象
     */
    @Override
    public Category detail(Integer categoryId) {
        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        Integer userId = (Integer) userMap.get("id");
        return categoryMapper.getCategoryDetailById(categoryId, userId);
    }

    /**
     * 更新类别信息
     *
     * @param category 包含更新信息的类别对象
     */
    @Override
    public void update(Category category) {
        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        Integer userId = (Integer) userMap.get("id");
        category.setCreateUser(userId);
        category.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        categoryMapper.update(category);
    }

    /**
     * 删除类别
     *
     * @param category 包含要删除类别信息的对象
     */
    @Override
    public void delete(Category category) {
        Map<String, Object> userMap = (Map<String, Object>) ThreadLocalUtil.get();
        Integer userId = (Integer) userMap.get("id");
        category.setCreateUser(userId);
        categoryMapper.delete(category);
    }
}