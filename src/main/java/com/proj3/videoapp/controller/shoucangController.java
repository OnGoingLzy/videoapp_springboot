package com.proj3.videoapp.controller;


import com.proj3.videoapp.entity.favorFolder;
import com.proj3.videoapp.entity.video;
import com.proj3.videoapp.service.shoucangServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class shoucangController {

    private shoucangServiceImpl shoucangService;
    public shoucangController(shoucangServiceImpl shoucangService){
        this.shoucangService = shoucangService;
    }

    @RequestMapping("getFolder")
    public List<favorFolder> getFolder(@RequestParam("cid" )String cid){

        return shoucangService.getFolder(cid);
    }
    @RequestMapping("getFolderVideo")
    public List<video> getFolderVideo(@RequestParam("folderid") String folderid){

        return shoucangService.getFolderVideo(folderid);

    }
    @RequestMapping("addFolder")
    public Boolean addFolder(@RequestParam("cid") String cid,
                             @RequestParam("folderName")String folderName,
                             @RequestParam("introduction")String introduction,
                             @RequestParam("limit") String limit){
        Integer limi = 0;
        if (limit.equals("true")){
            limi = 1;
        }
        favorFolder addFolder = new favorFolder(folderName,cid,introduction,limi);
        return shoucangService.addFolder(addFolder);
    }
    @RequestMapping("cancelShoucang")
    public Boolean cancelShoucang(@RequestParam("videoid") String videoid,@RequestParam("folderid") String folderid){

        return shoucangService.deleteBeShoucang(videoid,folderid);
    }
    @RequestMapping("changeFolderLimit")
    public Boolean changeFolderLimit(@RequestParam("folderid") String folderid,@RequestParam("limit") String limit){
        return shoucangService.changeFolderLimit(folderid,limit);
    }
    @RequestMapping("deleteFolder")
    public Boolean deleteFolder(@RequestParam("folderid") String folderid){
        return shoucangService.deleteFolder(folderid);
    }
}
