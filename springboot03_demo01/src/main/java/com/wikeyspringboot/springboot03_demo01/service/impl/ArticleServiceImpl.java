package com.wikeyspringboot.springboot03_demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wikeyspringboot.springboot03_demo01.mapper.ArticleMapper;
import com.wikeyspringboot.springboot03_demo01.pojo.Article;
import com.wikeyspringboot.springboot03_demo01.pojo.PageBean;
import com.wikeyspringboot.springboot03_demo01.service.ArticleService;
import com.wikeyspringboot.springboot03_demo01.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-21 11:34
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        Map<String, Object> userMap = ThreadLocalUtil.get();
        Integer userId = (Integer) userMap.get("id");
        article.setCreateUser(userId);
        article.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        article.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state) {
        PageBean<Article> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> userMap = ThreadLocalUtil.get();
        Integer userId = (Integer) userMap.get("id");


        List<Article> articleList = articleMapper.getArticleList(categoryId, state, userId);
        Page<Article> articlePage = (Page<Article>) articleList;

        pageBean.setTotal(articlePage.getTotal());
        pageBean.setItems(articlePage.getResult());
        return pageBean;
    }
}