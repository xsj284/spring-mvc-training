package com.xsj284.training.service;

import com.xsj284.training.entity.User;
import com.xsj284.training.service.model.LoginModel;
import com.xsj284.training.service.model.UserChangeModel;

import java.util.List;

public interface UserService {
    LoginModel userLogin(String username, String password);

    int userRegister(String username, String password);

    int userInfoUpdate(User user);

    int userInfoUpdateById(User user);

    List<User> getAllUsers();

    int getIdByName(String username);

    int deleteUser(int id);

    User getUserByName(String username);

    int changePassword(UserChangeModel info);
}
