package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.TRoleMapper;
import com.qf.j1902.mapper.TShiroUserMapper;
import com.qf.j1902.mapper.UserMapper;
import com.qf.j1902.pojo.*;
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
    @Autowired
    private TShiroUserMapper tShiroUserMapper;
    @Autowired
    private TRoleMapper tRoleMapper;
    //查询用户名是否已存在
    @Override
    public List<User> getUsers() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    //注册用户
    @Override
    public boolean addUser(User user) {
        int addUser = userMapper.insertSelective(user);
        //设置默认角色为普通会员
        String username = user.getUsername();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        Integer userid = userMapper.selectByExample(userExample).get(0).getUserid();
        //默认为普通会员
        Integer roleid = 6;
        TShiroUser tShiroUser = new TShiroUser();
        tShiroUser.setRoleId(roleid);
        tShiroUser.setUserId(userid);
        int insert = tShiroUserMapper.insert(tShiroUser);

        if (addUser == 1 && insert == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<User> getUserByName(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
    //根据登录名获取角色
    @Override
    public String getRoleNameByUid(Integer userid) {
        //根据登录名在角色id个userid连表中获取角色id
        TShiroUserExample tShiroUserExample = new TShiroUserExample();
        TShiroUserExample.Criteria criteria = tShiroUserExample.createCriteria();
        criteria.andUserIdEqualTo(userid);
        List<TShiroUser> tShiroUsers = tShiroUserMapper.selectByExample(tShiroUserExample);
        Integer roleId = tShiroUsers.get(0).getRoleId();
        //根绝角色id获取角色名
        String roleName = tRoleMapper.selectByPrimaryKey(roleId).getRoleName();
        return roleName;
    }

    @Override
    public boolean updateUpw(User user ) {
        UserExample userExample = new UserExample();
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }
}
