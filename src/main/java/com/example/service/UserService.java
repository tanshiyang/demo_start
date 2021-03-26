package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
public interface UserService extends IService<User> {
    //    @Autowired
//    UserMapper userMapper;
//    public User Sel(String id){
//        return userMapper.Sel(id);
//    }
    public User Sel(String id);

    public List<User> getList(QueryWrapper queryWrapper);
}