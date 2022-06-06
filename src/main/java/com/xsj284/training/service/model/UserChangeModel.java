package com.xsj284.training.service.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xsj284
 * created date: <p>2022/6/7<p>
 */
@Getter
@Setter
public class UserChangeModel {
    private String username;
    private String password;
    private String newPassword;
}
