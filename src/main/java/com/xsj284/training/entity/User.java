package com.xsj284.training.entity;


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
    private String sex;
    private Date birthday;
    private String address;
    private String profilePhoto;
    private String personalSignature;
}
