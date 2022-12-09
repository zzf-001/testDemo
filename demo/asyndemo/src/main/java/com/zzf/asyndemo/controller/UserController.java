package com.zzf.asyndemo.controller;




import com.zzf.asyndemo.pojo.User;
import com.zzf.asyndemo.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @RequestMapping("inserUser")
    @Transactional
    public void inserUser(){
        userService.insertUser();
    }
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public List<User> getUser(){
        System.out.println(123);
        return userService.getUser();
    }
}
