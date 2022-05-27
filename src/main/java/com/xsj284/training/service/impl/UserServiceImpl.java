package com.xsj284.training.service.impl;

import com.xsj284.training.dao.UserDao;
import com.xsj284.training.entity.User;
import com.xsj284.training.entity.UserPwd;
import com.xsj284.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xsj284
 * created date: <p>2022/5/25<p>
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int userLogin(String username, String password) {
        // unregistered
        if (userDao.isExistsByName(username) == 0) {
            return 0;
        }
        // login successful
        String tempPassword = userDao.selectUserPwd(userDao.selectIdByName(username));
        if (password.equals(tempPassword)) {
            return 1;
        }
        // login failed
        return -1;
    }

    @Override
    public int userRegister(String username, String password) {
        //username already registered
        if (userDao.isExistsByName(username) == 1) {
            return 0;
        }

        //insert user info and password
        User user = new User();
        user.setUsername(username);
        int temp1 = userDao.insertUser(user);
        if (temp1 == 0) {
            return -1;
        }
        int temp2 = userDao.selectIdByName(username);
        if (temp2 == 0) {
            return -1;
        }
        UserPwd userPwd = new UserPwd();
        userPwd.setId(temp2);
        userPwd.setPwd(password);
        int temp3 = userDao.insertUserPwd(userPwd);
        // register successful
        if (temp3 > 0) {
            return 1;
        }

        //another
        return -1;
    }
}
