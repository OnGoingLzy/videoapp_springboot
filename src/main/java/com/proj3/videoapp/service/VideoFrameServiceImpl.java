package com.proj3.videoapp.service;

import com.proj3.videoapp.Dao.VideoDao;
import com.proj3.videoapp.Dao.VideoFrameDao;
import com.proj3.videoapp.entity.comment;
import com.proj3.videoapp.entity.userAndComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "VideoFrameService")
public class VideoFrameServiceImpl implements VideoFrameService{
    @Autowired
    VideoFrameDao videoFrameDao;

    @Override
    public Boolean checkBeLike(String cid, String videoid) {
        String sql = "select * from belikesvideo where cid = '"+cid+"' and videoid = '"+videoid+"'";
        if(videoFrameDao.checkSql(sql)==null){
            return false;
        }else return true;
    }

    @Override
    public Boolean addBeLike(String cid, String videoid) {
        String sql = "insert into belikesvideo(cid,videoid) values("+cid+","+videoid+")";

        return videoFrameDao.insertSql(sql);
    }
    @Override
    public Boolean deleteBeLike(String cid, String videoid) {
        String sql = "delete from belikesvideo where cid = "+cid+" and videoid = "+videoid;

        return videoFrameDao.deleteSql(sql);
    }
    @Override
    public Boolean checkBeLikeComment(String cid, String commentid) {
        String sql = "select * from belikecomment where cid = '"+cid+"' and commentid = '"+commentid+"'";
        if(videoFrameDao.checkSql(sql)==null){
            return false;
        }else return true;
    }

    @Override
    public Boolean addBeLikeComment(String cid, String commentid) {
        String sql = "insert into belikecomment(cid,commentid) values("+cid+","+commentid+")";

        return videoFrameDao.insertSql(sql);
    }

    @Override
    public Boolean deleteBeLikeComment(String cid, String commentid) {
        String sql = "delete from belikecomment where cid = "+cid+" and commentid = "+commentid;

        return videoFrameDao.deleteSql(sql);
    }

    @Override
    public Boolean deleteComment(String commentid,String videoid,String cid) {
        //???????????????????????????root?????????????????????????????????
        String sql = "delete from comments where commentid = "+commentid;
        return videoFrameDao.deleteSql(sql);
    }

    @Override
    public Boolean shoucangVideo(String videoid, String folderid) {
        String sql = "insert into allbecollected(collectedvideoid,folderid) values("+videoid+","+folderid+")";
        return videoFrameDao.insertSql(sql);
    }

    @Override
    public Boolean checkBeCollected(String videoid, String cid) {
        String sql = "select * from allbecollected where collectedvideoid = '"+videoid+"' and folderid in (select ffolderid from favorfolder where ownerid = '"+cid+"')";
        int size = videoFrameDao.checkBeCollectedSql(sql).size();
        if(size<1){
            return false;
        }else return true;

    }

    @Override
    public List<comment> getVideoComment(String videoid) {
        String sql="select * from comments where videoid = " + videoid + " and tocommentid is NULL";
        List<comment> comment= videoFrameDao.getComment(sql);
        return comment;
    }

    @Override
    public List<comment> getCommentReply(String videoid, String toCommentid) {
        String sql="select * from comments where videoid = " + videoid + " and tocommentid = "+toCommentid;
        List<comment> comment= videoFrameDao.getComment(sql);
        if (comment.size()==0)return null;
        return comment;
    }

    @Override
    public Boolean submitComment(comment comment) {
        String sql = "insert into comments(videoid,cid,content,tocommentid,date) values("+comment.getVideoid()+","+comment.getCid()+",'"+comment.getContent()+"',"+comment.getTocommentid()+",now()) ";
        return videoFrameDao.insertSql(sql);
    }


}
