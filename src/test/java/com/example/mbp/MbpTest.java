package com.example.mbp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MbpTest {
    @Autowired
    UserService userService;

    @Test
    public void Test01() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, "1");
        queryWrapper.apply("userName='admin'");
        System.out.println("getCustomSqlSegment:" + queryWrapper.getCustomSqlSegment());
        System.out.println("getSqlSegment:" + queryWrapper.getSqlSegment());
        System.out.println("getTargetSql:" + queryWrapper.getTargetSql());
        System.out.println("getSqlSelect:" + queryWrapper.getSqlSelect());
        userService.getBaseMapper().selectList(queryWrapper);
    }

    @Test
    public void test02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        userService.getList(queryWrapper);
    }
}
