package com.example.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class IniRealmTest {
    IniRealm realm = new IniRealm("classpath:Users.ini");

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

        subject.checkPermission("article:delete");

        subject.logout();
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

    }
}
