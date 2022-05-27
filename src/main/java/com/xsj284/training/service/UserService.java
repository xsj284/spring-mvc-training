package com.xsj284.training.service;

public interface UserService {
    int userLogin(String username, String password);

    int userRegister(String username, String password);
}
