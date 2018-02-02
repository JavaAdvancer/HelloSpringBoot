package com.lbh;

import com.lbh.Service.UserService;
import com.lbh.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Advancer on 2018/1/15 14:46.
 * auth: lbh
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findOneTest(){
        User user = userService.findUserById(3);
        Assert.assertEquals("24", user.getAge());
    }

}
