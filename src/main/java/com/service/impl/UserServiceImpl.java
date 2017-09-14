package com.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.repository.entity.User;
import com.repository.mapper.UserMapper;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Description: UserServiceImpl
 * @Author: lin.shi
 * @CreateTime: 2017-09-12 17:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Page<User> list(int pageSize, int pageIndex) {
        PageHelper.startPage(pageIndex, pageSize);
        return (Page<User>) userMapper.list();

    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
