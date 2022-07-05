package com.proj3.videoapp.controller;

import com.proj3.videoapp.service.VideoFrameService;
import com.proj3.videoapp.service.VideoFrameServiceImpl;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class videoFrameController {

    private VideoFrameServiceImpl videoFrameService;
    public videoFrameController(VideoFrameServiceImpl videoFrameService){
        this.videoFrameService = videoFrameService;
    }

    @RequestMapping("checkBeCollected")
    public Boolean checkBeCollected(@RequestParam("videoid")String videoid,@RequestParam("cid") String cid){
        return videoFrameService.checkBeCollected(videoid,cid);
    }

    @RequestMapping("checkBeLike")
    public Boolean checkBeLike(@RequestParam("cid") String cid,@RequestParam("videoid") String videoid){

        return videoFrameService.checkBeLike(cid,videoid);
    }
    @RequestMapping("addBeLike")
    public Boolean addBeLike(@RequestParam("cid") String cid,@RequestParam("videoid") String videoid){

        return videoFrameService.addBeLike(cid,videoid);
    }
    @RequestMapping("deleteBeLike")
    public Boolean deleteBeLike(@RequestParam("cid") String cid,@RequestParam("videoid") String videoid){

        return videoFrameService.deleteBeLike(cid,videoid);
    }
    @RequestMapping("shoucangVideo")
    public Boolean shoucangVideo(@RequestParam("videoid")String videoid,@RequestParam("folderid") String folderid){
        return videoFrameService.shoucangVideo(videoid,folderid);
    }


}
