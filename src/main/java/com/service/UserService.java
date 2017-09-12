package com.service;

import com.github.pagehelper.Page;
import com.repository.entity.User;

/**
 * @Description: UserService
 * @Author: lin.shi
 * @CreateTime: 2017-09-12 17:38
 */
public interface UserService {

    Page<User> list(int pageSize, int pageIndex);
}
