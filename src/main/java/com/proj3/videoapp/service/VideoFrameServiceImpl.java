package com.proj3.videoapp.service;

import com.proj3.videoapp.Dao.VideoDao;
import com.proj3.videoapp.Dao.VideoFrameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "VideoFrameService")
public class VideoFrameServiceImpl implements VideoFrameService{
    @Autowired
    VideoFrameDao videoFrameDao;

    @Override
    public Boolean checkBeLike(String cid, String videoid) {
        String sql = "select * from belikesvideo where cid = '"+cid+"' and videoid = '"+videoid+"'";
        System.out.println(sql);
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
    public Boolean shoucangVideo(String videoid, String folderid) {
        String sql = "insert into allbecollected(collectedvideoid,folderid) values("+videoid+","+folderid+")";
        return videoFrameDao.insertSql(sql);
    }

    @Override
    public Boolean checkBeCollected(String videoid, String cid) {
        String sql = "select * from allbecollected where collectedvideoid = '"+videoid+"' and folderid in (select ffolderid from favorfolder where ownerid = '"+cid+"')";
        System.out.println(sql);
        int size = videoFrameDao.checkBeCollectedSql(sql).size();
        System.out.println(size);
        if(size<1){
            return false;
        }else return true;

    }
}
