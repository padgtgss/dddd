package com.controller;

import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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


}
