package com.wikeyspringboot.springboot03_demo01.mapper;

import com.wikeyspringboot.springboot03_demo01.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO ARTICLE (TITLE, CONTENT, COVER_IMG, STATE, CATEGORY_ID, CREATE_USER, CREATE_TIME, UPDATE_TIME) VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    List<Article> getArticleList(String categoryId, String state, Integer userId);
}