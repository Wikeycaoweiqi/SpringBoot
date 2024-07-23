package com.wikeyspringboot.springboot03_demo01.service;

import com.wikeyspringboot.springboot03_demo01.pojo.Article;
import com.wikeyspringboot.springboot03_demo01.pojo.PageBean;

public interface ArticleService {

    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state);
}