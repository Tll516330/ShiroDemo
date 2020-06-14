package com.example.shiortwodemo.service;

import com.example.shiortwodemo.pojo.User;

/**
 * @author tll
 * @create 2020/6/11 17:02
 */
public interface UserService {
    /**
     * 通过name查询用户
     * @param name
     * @return
     */
    User findByName(String name);
}
