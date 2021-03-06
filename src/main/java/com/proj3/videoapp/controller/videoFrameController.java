package com.proj3.videoapp.controller;

import com.proj3.videoapp.entity.comment;
import com.proj3.videoapp.entity.userAndComment;
import com.proj3.videoapp.service.VideoFrameService;
import com.proj3.videoapp.service.VideoFrameServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //检索视频是否被点赞
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
    @RequestMapping("checkBeLikeComment")
    public Boolean checkBeLikeComment(@RequestParam("cid")String cid,@RequestParam("commentid") String commentid){
        return videoFrameService.checkBeLikeComment(cid,commentid);
    }
    @RequestMapping("addBeLikeComment")
    public Boolean addBeLikeComment(@RequestParam("cid") String cid,@RequestParam("commentid") String commentid){

        return videoFrameService.addBeLikeComment(cid,commentid);
    }
    @RequestMapping("delBeLikeComment")
    public Boolean deleteBeLikeComment(@RequestParam("cid") String cid,@RequestParam("commentid") String commentid){

        return videoFrameService.deleteBeLikeComment(cid,commentid);
    }
    @RequestMapping("delComment")
    public Boolean deleteComment(@RequestParam("commentid") String commentid,@RequestParam("videoid") String videoid,@RequestParam("cid") String cid){
        return videoFrameService.deleteComment(commentid,videoid,cid);
    }
    @RequestMapping("shoucangVideo")
    public Boolean shoucangVideo(@RequestParam("videoid")String videoid,@RequestParam("folderid") String folderid){
        return videoFrameService.shoucangVideo(videoid,folderid);
    }
    @RequestMapping("getVideoComment")
    public List<comment> getVideoComment(@RequestParam("videoid") String videoid){
        return videoFrameService.getVideoComment(videoid);
    }
    //查找评论的评论or回复
    @RequestMapping("getCommentReply")
    public List<comment> getCommentReply(@RequestParam("videoid") String videoid,@RequestParam("toCommentid") String toCommentid){
        return videoFrameService.getCommentReply(videoid,toCommentid);
    }
    //保存评论
    @RequestMapping("submitComment")
    public Boolean submitComment(@RequestParam("content") String content,
                                 @RequestParam("videoid")String videoid,
                                 @RequestParam("tocommentid")String tocommentid,
                                 @RequestParam("cid")String cid){

        comment comment = new comment(videoid,cid,content,tocommentid);

        return videoFrameService.submitComment(comment);

    }

}
