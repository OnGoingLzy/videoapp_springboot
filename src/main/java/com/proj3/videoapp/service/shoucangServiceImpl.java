package com.proj3.videoapp.service;

import com.proj3.videoapp.Dao.ShoucangDao;
import com.proj3.videoapp.entity.favorFolder;
import com.proj3.videoapp.entity.video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shoucangService")
public class shoucangServiceImpl implements shoucangService{
    @Autowired
    ShoucangDao shoucangDao;

    @Override
    public List<favorFolder> getFolder(String cid) {
        return shoucangDao.getFolder(cid);
    }

    @Override
    public List<video> getFolderVideo(String folderid) {
        String sql = "SELECT * from video where videoid in (SELECT collectedvideoid from allbecollected where folderid = "+folderid+")";

        return shoucangDao.selectVideo(sql);
    }

    @Override
    public Boolean addFolder(favorFolder addFolder) {
        String sql = "insert into favorfolder(ownerid,ffoldername,introduction,`limit`) values ("+addFolder.getOwnerid()+",'"+addFolder.getFfoldername()+"','"+addFolder.getIntroduction()+"',"+addFolder.getLimit()+")";
        return shoucangDao.insertSql(sql);
    }

    @Override
    public Boolean deleteBeShoucang(String videoid,String folderid) {
        String sql = "delete from allbecollected where collectedvideoid = "+videoid + " and folderid = "+folderid;
        return shoucangDao.deleteSql(sql);
    }
}
