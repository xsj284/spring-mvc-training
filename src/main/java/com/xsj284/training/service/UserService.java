package com.xsj284.training.service;

import com.xsj284.training.service.model.LoginModel;

public interface UserService {
    LoginModel userLogin(String username, String password);

    int userRegister(String username, String password);
}
