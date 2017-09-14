package com.repository.entity;

import com.repository.entity.common.BaseEntity;

/**
 * @Description: User
 * @Author: lin.shi
 * @CreateTime: 2017-09-12 16:43
 */
public class User extends BaseEntity {


    private String username;

    private String password;

    //==================================getter  and  setter =======================


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
