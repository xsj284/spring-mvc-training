package com.xsj284.training.controller;

import com.xsj284.training.service.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xsj284
 * created date: <p>2022/5/29<p>
 */
@Controller
public class PageController {
    @RequestMapping(value = "index")
    public String toIndex() {
        return "/";
    }
}
