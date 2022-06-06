package com.xsj284.training.service.impl;

import com.xsj284.training.dao.ArticleDao;
import com.xsj284.training.entity.Article;
import com.xsj284.training.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xsj284
 * created date: <p>2022/5/29<p>
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDao.selectAll();
    }

    @Override
    public int deleteArticle(int id) {
        return articleDao.deleteArticle(id);
    }

    @Override
    public int addArticleInfo(String title, String author, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setAuthor(author);
        article.setContent(content);
        return articleDao.insertArticle(article);
    }

    @Override
    public int selIdByAuthor(String author) {
        return articleDao.selIdByAuthor(author);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }
}
