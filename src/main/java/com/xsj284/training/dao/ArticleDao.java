package com.xsj284.training.dao;

import com.xsj284.training.entity.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xsj284
 * created date: <p>2022/5/29<p>
 */
@Repository
public interface ArticleDao {
    @Select("select * from tb_article where id=#{id};")
    @Result(column = "created_time", property = "createdTime")
    Article selectArticleById(int id);

    @Select("select id from tb_article where author=#{author} order by id desc limit 1;")
    int selIdByAuthor(String author);

    @Select("select * from tb_article;")
    @Result(column = "created_time", property = "createdTime")
    List<Article> selectAll();

    @Insert("insert into tb_article (title, author, content)" +
            " values (#{title}, #{author}, #{content});")
    int insertArticle(Article article);

    @Update("update tb_article set " +
            "title = #{title}, author = #{author}, content = #{content} " +
            "where id = #{id};")
    int updateArticle(Article article);

    @Delete("delete from tb_article where id=#{id};")
    int deleteArticle(int id);
}
