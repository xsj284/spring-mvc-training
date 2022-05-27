package com.xsj284.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xsj284
 * created date: <p>2022/5/24<p>
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(value = {
        "com.xsj284.training.dao",
        "com.xsj284.training.service",
        "com.xsj284.training.config"
})
@Import({JdbcConfig.class, MyBatisConfig.class})
public class SpringConfig {
}
