package service;

import com.xsj284.training.config.SpringConfig;
import com.xsj284.training.service.UserService;
import com.xsj284.training.service.model.LoginModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xsj284
 * created date: <p>2022/5/25<p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void LoginTest() {
        LoginModel loginCode = userService.userLogin("xsj284", "123456");
        System.out.println(loginCode);
    }
}
