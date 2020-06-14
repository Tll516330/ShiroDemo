package com.example.shiortwodemo.daoimpl;

import com.example.shiortwodemo.dao.UserDao;
import com.example.shiortwodemo.mapper.UserMapper;
import com.example.shiortwodemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tll
 * @create 2020/6/11 17:04
 */
@Repository
public class UserDapImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findByName(String name) {
        User user = new User();
        user.setName(name);
        User user1 = userMapper.selectOne(user);
        return user1;
    }
}
