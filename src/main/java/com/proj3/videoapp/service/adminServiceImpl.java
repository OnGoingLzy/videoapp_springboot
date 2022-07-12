package com.proj3.videoapp.service;


import com.proj3.videoapp.Dao.AdminDao;
import com.proj3.videoapp.Dao.VideoDao;
import com.proj3.videoapp.entity.video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class adminServiceImpl implements adminService{
    @Autowired
    VideoDao videoDao;
    @Autowired
    AdminDao adminDao;

    @Override
    public List<video> getAuditVideo() {
        String sql = "select * from video where status = 1 ";

        return videoDao.getVideoList(sql);
    }

    @Override
    public Boolean passVideoAudit(String videoid) {
        String sql = "update video set status = 2 where videoid = "+videoid;
        return adminDao.updateSql(sql);
    }
}
