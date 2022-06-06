package com.xsj284.training.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author xsj284
 * created date: <p>2022/5/29<p>
 */
@Getter
@Setter
@ToString
public class Article {
    private int id;
    private String title;
    private String author;
    private String content;
    private Date createdTime;
}
