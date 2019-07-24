package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.UserMapper;
import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserExample;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2019/7/23.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public boolean addUser(User user) {
        int addUser = userMapper.insertSelective(user);
        if (addUser == 1){
            return true;
        }else {
            return false;
        }
    }
}
