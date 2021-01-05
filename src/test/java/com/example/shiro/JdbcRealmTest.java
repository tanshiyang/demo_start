package com.example.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class JdbcRealmTest {
    DruidDataSource dataSource = new DruidDataSource();
    JdbcRealm realm = new JdbcRealm();

    @Before
    public void setRealm(){
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123123");
        realm.setDataSource(dataSource);
        realm.setPermissionsLookupEnabled(true);
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

        subject.checkPermission("article:update");

        subject.logout();
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

    }
}
