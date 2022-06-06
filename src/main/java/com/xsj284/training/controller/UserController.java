package com.xsj284.training.controller;

import com.xsj284.training.controller.view.UserInfo;
import com.xsj284.training.controller.view.UserLoginInfo;
import com.xsj284.training.entity.User;
import com.xsj284.training.service.UserService;
import com.xsj284.training.service.model.LoginModel;
import com.xsj284.training.service.model.UserChangeModel;
import com.xsj284.training.utils.DateUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xsj284
 * created date: <p>2022/5/25<p>
 */
@Controller
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*登录验证*/
    @RequestMapping(value = "loginVerify", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int loginVerify(HttpServletRequest request, @RequestBody UserLoginInfo userLoginInfo) {
        LoginModel loginModel = userService.userLogin(userLoginInfo.getUsername(), userLoginInfo.getPassword());
        request.getSession().setAttribute("loginModel", loginModel);
        return loginModel.getLoginCode();
    }

    /*登出*/
    @RequestMapping(value = "loginOut")
    @ResponseBody
    public void loginOut(HttpServletRequest request) {
        LoginModel loginModel = (LoginModel) request.getSession().getAttribute("loginModel");
        if (loginModel.getLoginCode() == 1) {
            request.getSession().setAttribute("loginModel", null);
        }
    }

    /*登录信息获取*/
    @GetMapping(value = "isLoginSuccess")
    @ResponseBody
    public LoginModel isLoginSuccess(HttpServletRequest request) {
        return (LoginModel) request.getSession().getAttribute("loginModel");
    }

    /*注册验证*/
    @PostMapping(value = "registerVerify")
    @ResponseBody
    public int registerVerify(@RequestBody UserLoginInfo userLoginInfo) {
        return userService.userRegister(userLoginInfo.getUsername(), userLoginInfo.getPassword());
    }

    /*修改密码*/
    @PostMapping(value = "changeVerify")
    @ResponseBody
    public int changeVerify(@RequestBody UserChangeModel info) {
        return userService.changePassword(info);
    }

    @RequestMapping(value = "userUpdateInfo", produces = "application/json")
    @ResponseBody
    public int updateInfo(HttpServletRequest request, @RequestBody UserInfo userInfo) {
        User user = new User();
        user.setUsername(((LoginModel) request.getSession().getAttribute("loginModel")).getUsername());
        user.setSex(userInfo.getSex());
        user.setAddress(userInfo.getAddress());
        user.setBirthday(new java.sql.Date(DateUtil.dateStringToLong(userInfo.getBirthday())));
        user.setPersonalSignature(userInfo.getPersonalSignature());
        return userService.userInfoUpdate(user);
    }

    @RequestMapping(value = "getLoginUser")
    @ResponseBody
    public UserInfo getLoginUser(HttpServletRequest request) {
        String username = null;
        try {
            username = ((LoginModel) request.getSession().getAttribute("loginModel")).getUsername();
        } catch (NullPointerException ignored) {
        }
        if (username == null) {
            return null;
        }
        return new UserInfo(userService.getUserByName(username));
    }


    @RequestMapping(value = "getUserInfo")
    @ResponseBody
    public List<UserInfo> getUserInfo() {
        List<User> userList = userService.getAllUsers();
        List<UserInfo> userInfoList = new ArrayList<>();
        for (User user : userList) {
            UserInfo userInfo = new UserInfo(user);
            userInfoList.add(userInfo);
        }
        return userInfoList;
    }

    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public int deleteUser(@RequestBody String str) {
        JSONObject jsonObject = new JSONObject(str);
        return userService.deleteUser(jsonObject.getInt("id"));
    }
}
