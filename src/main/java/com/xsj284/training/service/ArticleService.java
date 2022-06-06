package com.xsj284.training.service;

import com.xsj284.training.entity.Article;

import java.util.List;

/**
 * @author xsj284
 * created date: <p>2022/5/29<p>
 */
public interface ArticleService {
    List<Article> getAllArticles();

    int deleteArticle(int id);

    int addArticleInfo(String title, String author, String content);

    int selIdByAuthor(String author);

    int updateArticle(Article article);
}
