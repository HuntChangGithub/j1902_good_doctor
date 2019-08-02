package com.qf.j1902.shiro;

import com.qf.j1902.pojo.User;
import com.qf.j1902.service.UserPermissionService;
import com.qf.j1902.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by asus on 2019/7/24.
 */
public class MyRealm extends AuthorizingRealm {
    //    注入用户业务接口
    @Autowired
    private UserService userService;
    @Autowired
    private UserPermissionService userPermissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String principal = (String)principals.getPrimaryPrincipal();
        //Set<UserPermission> permissionSet = userPermissionService.getPermsByName(principal);
       return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        String principal = (String)token.getPrincipal();
        List<User> users = userService.getUserByName(principal);
        SimpleAuthenticationInfo authenticationInfo = null;
        if (users.size() != 0){
            User user = users.get(0);
            authenticationInfo = new SimpleAuthenticationInfo(principal,user.getUpassword(),null,this.getName());
        }
        return authenticationInfo;
    }
}
