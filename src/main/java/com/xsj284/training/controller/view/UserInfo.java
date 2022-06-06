package com.xsj284.training.controller.view;

import com.xsj284.training.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xsj284
 * created date: <p>2022/5/29<p>
 */
@Getter
@Setter
@ToString
public class UserInfo {
    private int id;
    private String username;
    private String sex;
    private String birthday;
    private String address;
    private String profilePhoto;
    private String personalSignature;
    private int admin;

    public UserInfo() {
    }

    public UserInfo(User user) {
        id = user.getId();
        username = user.getUsername();
        sex = user.getSex();
        birthday = user.getBirthday().toString();
        address = user.getAddress();
        profilePhoto = user.getProfilePhoto();
        personalSignature = user.getPersonalSignature();
        admin = user.getAdmin();
    }
}
