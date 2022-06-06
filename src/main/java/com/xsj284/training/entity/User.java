package com.xsj284.training.entity;


import com.xsj284.training.utils.DateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 * @author xsj284
 * <p>created date: 2022/5/14</p>
 */
@Setter
@Getter
@ToString
public class User {
    private int id;
    private String username;
    private String sex = "未知";
    private Date birthday = new Date(DateUtil.dateStringToLong("2000-01-01"));
    private String address = "";
    private String profilePhoto = "img/userProfile/default.png";
    private String personalSignature = "";

    private int admin = 0;
}
