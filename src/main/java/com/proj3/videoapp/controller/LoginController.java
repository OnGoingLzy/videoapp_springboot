package com.proj3.videoapp.controller;

import com.proj3.videoapp.Dao.UserDao;
import com.proj3.videoapp.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController //只返回值所用
public class LoginController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/login")
    public user login(@RequestBody user user){
        System.out.println("User " + user);
        user user1 = userDao.getUserByMassage(user.getEmail(),user.getCpwd());
        System.out.println(user1);
        return user1;
    }
    @RequestMapping("/register")
    public Boolean register(@RequestBody user user){
        String sql = "insert into user(cname,email,cpwd) values('"+user.getCname()+"','"+user.getEmail()+"','"+user.getCpwd()+"')";
        return userDao.insertSql(sql);
    }


}
