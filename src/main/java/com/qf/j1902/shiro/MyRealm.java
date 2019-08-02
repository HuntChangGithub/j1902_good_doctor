package com.qf.j1902.shiro;

import com.qf.j1902.pojo.TPermission;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.PermissionService;
import com.qf.j1902.service.UserPermissionService;
import com.qf.j1902.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by asus on 2019/7/24.
 */
public class MyRealm extends AuthorizingRealm {
    //    注入用户业务接口
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String principal = (String)principals.getPrimaryPrincipal();
        System.out.println(principal);
        Set<TPermission> permissionSet = permissionService.getPermsByName(principal);
        Set<String> perms = new HashSet<>();
        if(permissionSet!=null){
            for (TPermission perm: permissionSet ) {
                perms.add(perm.getMenuUrl());//获取权限名称组成权限集合
            }
        }
        //System.out.println(perms);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(perms);//设置权限
        return authorizationInfo;
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
