package com.xsj284.training.controller;

import com.xsj284.training.controller.view.UserLoginInfo;
import com.xsj284.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
        int loginCode = userService.userLogin(userLoginInfo.getUsername(), userLoginInfo.getPassword());
        request.getSession().setAttribute("loginCode", loginCode);
        request.getSession().setAttribute("username", userLoginInfo.getUsername());
        return loginCode;
    }

    /*登出*/
    @RequestMapping(value = "loginOut")
    @ResponseBody
    public int loginOut(HttpServletRequest request) {
        if ((int) request.getSession().getAttribute("loginCode") == 1) {
            request.getSession().setAttribute("loginCode", 0);
            request.getSession().setAttribute("username", null);
            return 1;
        }
        return 0;
    }

    /*登录信息获取*/
    @GetMapping(value = "isLoginSuccess")
    @ResponseBody
    public Map<String, Object> isLoginSuccess(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        if (request.getSession() != null) {
            map.put("loginCode", request.getSession().getAttribute("loginCode"));
            map.put("username", request.getSession().getAttribute("username"));
        }
        return map;
    }

    /*注册验证*/
    @PostMapping(value = "registerVerify")
    @ResponseBody
    public int registerVerify(HttpServletRequest request, @RequestBody UserLoginInfo userLoginInfo) {
        int registerCode = userService.userRegister(userLoginInfo.getUsername(), userLoginInfo.getPassword());
        request.getSession().setAttribute("username", userLoginInfo.getUsername());
        return registerCode;
    }
}
