package com.xsj284.training.controller;

import com.xsj284.training.controller.view.UserLoginInfo;
import com.xsj284.training.service.UserService;
import com.xsj284.training.service.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public int registerVerify(HttpServletRequest request, @RequestBody UserLoginInfo userLoginInfo) {
        return userService.userRegister(userLoginInfo.getUsername(), userLoginInfo.getPassword());
    }
}
