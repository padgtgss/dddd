package com.controller;

import com.repository.entity.User;
import com.repository.entity.common.AvailableEnum;
import com.service.UserService;
import com.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description: UserController
 * @Author: lin.shi
 * @CreateTime: 2017-09-12 17:53
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(int pageIndex, int pageSize) {
        return userService.list(pageSize, pageIndex);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public void add() {
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
