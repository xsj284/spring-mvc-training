package com.xsj284.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author xsj284
 * created date: <p>2022/5/25<p>
 */
@Configuration
@ComponentScan({"com.xsj284.training.controller", "com.xsj284.training.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
