package com.proj3.videoapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class adminController {
    @RequestMapping("passAudit")
    public Boolean passAudit(){
        return false;
    }

}
