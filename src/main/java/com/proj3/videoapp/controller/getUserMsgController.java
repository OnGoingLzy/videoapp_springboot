package com.proj3.videoapp.controller;

import com.proj3.videoapp.Dao.UserDao;
import com.proj3.videoapp.entity.userMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//此类用于写获取用户相关信息的方法
@CrossOrigin //此方法要写  跨域
@RestController
public class getUserMsgController {
//    @Autowired
//    UserDao userdao;
//    @RequestMapping("/getMsgImg")
//    public userMsg getmsgimg(@RequestBody String cid){
//        cid = cid.replace("=","");
//        userMsg sm = userdao.getUserAvatar(cid);
//        return sm;
//    }
}
