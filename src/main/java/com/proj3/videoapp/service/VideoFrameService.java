package com.proj3.videoapp.service;

import com.proj3.videoapp.entity.comment;
import com.proj3.videoapp.entity.userAndComment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoFrameService {
    public Boolean checkBeLike(String cid , String videoid);
    public Boolean addBeLike(String cid,String videoid);
    public Boolean deleteBeLike(String cid,String videoid);
    public Boolean shoucangVideo(String videoid,String folderid);
    public Boolean checkBeCollected(String videoid,String cid);
    public List<comment> getVideoComment(String videoid);
    //List<comment> getCommentReply(String videoid, String tocid);错误的查询，修改成以父评论id查询子评论
    List<comment> getCommentReply(String videoid, String toCommentid);

    Boolean submitComment(comment comment);

    Boolean checkBeLikeComment(String cid, String commentid);

    Boolean addBeLikeComment(String cid, String commentid);

    Boolean deleteBeLikeComment(String cid, String commentid);

    Boolean deleteComment(String commentid,String videoid,String cid);
}
