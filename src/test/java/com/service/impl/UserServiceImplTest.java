package com.service.impl;

import com.repository.entity.User;
import com.repository.entity.common.AvailableEnum;
import com.service.UserService;
import com.util.UUIDUtils;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml", "/application-servlet.xml"})
class UserServiceImplTest extends TestCase {


    @Resource
    private UserService userService;

    @Test
    void list() {
        User user = new User();
        user.setPassword("11111");

        user.setUsername("zs");
        user.setAvailable(AvailableEnum.AVAILABLE);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setId(UUIDUtils.get());
        userService.insertUser(user);
    }

    @Test
    void insertUser() {
    }

    @Test
    void get() {
    }
}