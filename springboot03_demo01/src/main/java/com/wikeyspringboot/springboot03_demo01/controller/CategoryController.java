package com.wikeyspringboot.springboot03_demo01.controller;

import com.wikeyspringboot.springboot03_demo01.pojo.Category;
import com.wikeyspringboot.springboot03_demo01.pojo.Result;
import com.wikeyspringboot.springboot03_demo01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: wikey
 * @create: 2024-07-21 10:08
 * @Description:
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取所有类别列表
     *
     * @return 返回包含所有类别的列表的Result对象
     */
    @GetMapping
    public Result<List<Category>> list() {
        List<Category> categoryList = categoryService.list();
        return Result.success(categoryList);
    }

    /**
     * 添加新类别
     *
     * @param category 包含新类别信息的实体对象
     * @return 返回表示操作结果的Result对象
     */
    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }

    /**
     * 获取类别详情
     *
     * @param id 类别的唯一标识符
     * @return 返回包含类别详情的Result对象
     */
    @GetMapping(value = "detail")
    public Result<Category> detail(@RequestParam Integer id) {
        Category category = categoryService.detail(id);
        return Result.success(category);
    }

    /**
     * 更新类别信息
     *
     * @param category 包含更新信息的类别实体对象
     * @return 返回表示操作结果的Result对象
     */
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    /**
     * 删除类别
     *
     * @param category 包含要删除类别信息的实体对象
     * @return 返回表示操作结果的Result对象
     */
    @DeleteMapping
    public Result delete(@RequestBody @Validated(Category.Delete.class) Category category) {
        categoryService.delete(category);
        return Result.success();
    }
}