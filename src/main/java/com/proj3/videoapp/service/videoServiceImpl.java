package com.proj3.videoapp.service;

import com.proj3.videoapp.Dao.VideoDao;
import com.proj3.videoapp.entity.video;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "videoService")
public class videoServiceImpl implements videoService{
    @Autowired
    VideoDao videoDao;
    @Override
    public ArrayList<video> VideoListPage(String currentPage) {
        int cp = Integer.parseInt(currentPage);
        cp = (cp - 1 ) * videoService.PAGESIZE;
        int pageSize = videoService.PAGESIZE;
        return videoDao.VideoListPage(cp,pageSize);
    }

    @Override
    public int getMaxPage() throws SQLException {
        /**
         * 将条数转换为页数，获得当前条数属于第几页
         * 总条数/每页显示行数
         * */
        int page = 0;   //最大页数
        int videoCount = videoDao.videoCount();    //获取数据库总条数
        if (videoCount % videoService.PAGESIZE == 0){
            page = videoCount / videoService.PAGESIZE;
        }else {
            page = videoCount / videoService.PAGESIZE + 1;
        }
        return page;
    }

    @Override
    public int getAllCount() {
        int videoCount = videoDao.videoCount();
        return videoCount;
    }

    @Override
    public String[] getCategories() {

        return videoDao.videoCategories();
    }

    @Override
    public String[] getTag() {
        return videoDao.videoTag();
    }

    @Override
    public List<video> videoCTList(String currentPage, String sql) {
        int cp = Integer.parseInt(currentPage);
        cp = (cp - 1 ) * videoService.PAGESIZE;
        int pageSize = videoService.PAGESIZE;
        return videoDao.videoCTList(cp,pageSize,sql);
    }

    @Override
    public int getAllCount2(String sql) {
        return videoDao.videoCount2(sql);
    }

    @Override
    public video getVideo(String videoid) {
        String sql = "select * from video where videoid = '"+videoid+"'";

        return videoDao.getVideo(sql);
    }

    @Override
    public List<video> getVideoWithAuthor(String authorid) {
        String sql = "select * from video where authorid = '"+authorid+"' ORDER BY status desc,createtime desc";

        return videoDao.getVideoList(sql);
    }
}
