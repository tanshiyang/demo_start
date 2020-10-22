package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable String id){
//        return userService.Sel(id).toString();
        return userService.getById(id).toString();
    }

    @RequestMapping("getUserBySQL/{id}")
    public String GetUserBySQL(@PathVariable String id){
        return userService.Sel(id).toString();
    }
}