package com.qf.j1902.service;

import com.qf.j1902.pojo.User;

import java.util.List;

/**
 * Created by asus on 2019/7/23.
 */
public interface UserService {

    public List<User> getUsers();

    //添加用户
    public boolean addUser(User user);

    //通过用户名查user对象
    public List<User> getUserByName(String username);
    //通过用户id获取角色名
    public String getRoleNameByUid(Integer userid);
    //修改密码
    public boolean updateUpw(User user );
}
