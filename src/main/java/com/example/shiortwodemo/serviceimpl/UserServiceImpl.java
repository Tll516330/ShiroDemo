package com.example.shiortwodemo.serviceimpl;

import com.example.shiortwodemo.dao.UserDao;
import com.example.shiortwodemo.pojo.User;
import com.example.shiortwodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tll
 * @create 2020/6/11 17:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String name) {
        User user = userDao.findByName(name);
        return user;
    }
}
