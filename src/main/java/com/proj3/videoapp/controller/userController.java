package com.proj3.videoapp.controller;

import com.proj3.videoapp.Dao.UserDao;
import com.proj3.videoapp.entity.userMsg;
import com.proj3.videoapp.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class userController {
    private userServiceImpl userService;
    public userController(userServiceImpl userService){
        this.userService = userService;
    }
    @Autowired
    UserDao userDao;

    @RequestMapping("updateMsg")
    public String updateMsg(@RequestParam("cid") String cid,
                             @RequestParam("cname") String cname,
                             @RequestParam("introduction") String introduction,
                             @RequestParam("bkg") MultipartFile bkg,
                             @RequestParam("avatar") MultipartFile avatar
                            )
    {

        String avatarname = "default.png";
        String bkgname = "defaultBkg.png";
        if(avatar.getSize()!=0){
            String result = userService.uploadfile(avatar,"avatar");
            if(!result.equals("error"))avatarname=result;
        }
        if(bkg.getSize()!=0){
            String result = userService.uploadfile(bkg,"personalBackground");
            if(!result.equals("error"))bkgname = result;
        }

        String sql = "update usermsgimg set bkgname ='"+bkgname+"',avatarName = '"+avatarname+"',cname = '"+cname+"',introduction = '"+introduction+"' where cid = "+cid;
        System.out.println(sql);
        if(!userDao.updateSql(sql))return "数据库更新失败";
        return "success";
    }

    //名字不对，但是功能是获取用户信息
    @RequestMapping("/getMsgImg")
    public userMsg getmsgimg(@RequestBody String cid){
        cid = cid.replace("=","");
        userMsg sm = userDao.getUserAvatar(cid);
//        System.out.println(sm);
        return sm;
    }
}
