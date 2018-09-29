package com.repository.mapper;

import com.repository.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: UserMapper
 * @Author: lin.shi
 * @CreateTime: 2017-09-12 17:41
 */
public interface UserMapper {

    List<User> list();

    User get(@Param("id") String id);

    void insert(User user);
}
