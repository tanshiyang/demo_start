package com.example.shiro;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
    SimpleAccountRealm realm = new SimpleAccountRealm();
    @Before
    public void addUser(){
        realm.addAccount("admin","123","Admins");
    }

    @Test
    public void testAuthentication(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("admin","123");
        subject.login(token);
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        System.out.println("hasRole Admins:" + subject.hasRole("Admins"));

        subject.logout();
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

    }
}
