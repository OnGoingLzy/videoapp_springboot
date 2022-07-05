package com.proj3.videoapp.controller;

import com.proj3.videoapp.Dao.UserDao;
import com.proj3.videoapp.entity.userMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class userController {
    @Autowired
    UserDao userDao;

    @RequestMapping("updateMsg")
    public Boolean updateMsg(@RequestParam("cid") String cid,
                             @RequestParam("cname") String cname,
                             @RequestParam("introduction") String introduction)
    {
        String sql = "update usermsgimg set cname = '"+cname+"',introduction = '"+introduction+"' where cid = "+cid;
        System.out.println(sql);
        return userDao.updateSql(sql);
    }

    //名字不对，但是功能是获取用户信息
    @RequestMapping("/getMsgImg")
    public userMsg getmsgimg(@RequestBody String cid){
        cid = cid.replace("=","");
        userMsg sm = userDao.getUserAvatar(cid);
        return sm;
    }
}
