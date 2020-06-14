package com.example.shiortwodemo.dao;

import com.example.shiortwodemo.pojo.User;

/**
 * @author tll
 * @create 2020/6/11 17:04
 */
public interface UserDao {
    /**
     * 通过name查询用户
     * @param name
     * @return
     */
    User findByName(String name);
}
