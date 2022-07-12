package com.proj3.videoapp.controller;


import com.proj3.videoapp.entity.video;
import com.proj3.videoapp.service.adminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class adminController {

    private adminServiceImpl adminService;
    public adminController(adminServiceImpl adminService){
        this.adminService = adminService;
    }

    @RequestMapping("passAudit")
    public Boolean passAudit(){
        return false;
    }

    @RequestMapping("getAuditVideo")
    public List<video> getAuditVideo(){
        List<video> List =  adminService.getAuditVideo();
        if (List.size()==0){
            return null;
        }
        return List;
    }
    @RequestMapping("passVideoAudit")
    public Boolean passVideoAudit(@RequestParam("videoid") String videoid){
        return adminService.passVideoAudit(videoid);
    }

}

