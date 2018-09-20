package com.service;


import com.repository.entity.User;
import com.repository.entity.common.AvailableEnum;
import com.util.UUIDUtils;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml", "/application-servlet.xml"})
public class UserServiceTest extends TestCase {


    @Resource
    private UserService userService;

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setPassword("sdfsdf");

        user.setUsername("234sdf");
        user.setAvailable(AvailableEnum.AVAILABLE);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setId(UUIDUtils.get());
        userService.insertUser(user);


    }


}