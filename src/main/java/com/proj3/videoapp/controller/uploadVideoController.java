package com.proj3.videoapp.controller;


import com.proj3.videoapp.entity.preUploadVideo;
import com.proj3.videoapp.entity.preVideo;
import com.proj3.videoapp.service.uploadVideoServiceImpl;
import com.proj3.videoapp.service.videoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@CrossOrigin
@RestController
public class uploadVideoController {
    private videoServiceImpl videoService;
    private uploadVideoServiceImpl uploadVideoService;

    public uploadVideoController(videoServiceImpl videoService,uploadVideoServiceImpl uploadVideoService) {
        this.videoService = videoService;
        this.uploadVideoService = uploadVideoService;
    }
    //投稿第一步上传视频
    @RequestMapping("videoUpload")
    public String videoUpload(@RequestBody MultipartFile file){
        String path = uploadVideoService.uploadVideo(file);
        return path;
    }
    @RequestMapping("preUploadSave")
    public void preUploadSave(@RequestBody Map<String,Object> param){
        Boolean save = uploadVideoService.preUploadSave(param);

    }
    @RequestMapping("getPreUploadMsg")
    public preUploadVideo getPreUploadMsg(@RequestBody String cid){
        cid = cid.replace("=","");
        preUploadVideo puv =  uploadVideoService.getPreUploadMsg(cid);
        System.out.println(puv);
        return puv;
    }
    @RequestMapping("submitVideo")
    public Boolean submitVideo(@RequestParam("coverImg") MultipartFile coverImg,
                               @RequestParam("cid") String cid,
                               @RequestParam("videoPath") String videoPath,
                               @RequestParam("videoName") String videoName,
                               @RequestParam("tagResult") String tagResult,
                               @RequestParam("description") String description,
                               @RequestParam("category") String category
    ) throws IOException {
        tagResult = tagResult.replaceAll("(?:[|])","");
        preVideo preVideo = new preVideo(cid,coverImg,videoName,category,tagResult,videoPath,description);
        Boolean result = uploadVideoService.submitVideo(preVideo);
        return result;
    }
}
