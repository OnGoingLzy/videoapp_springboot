package com.proj3.videoapp.service;

import com.proj3.videoapp.entity.video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public interface videoService {
    int PAGESIZE = 4;   //每页显示视频数
    ArrayList<video> VideoListPage(String currentPage);

    int getMaxPage() throws SQLException;

    //查询所有数据条数
    int getAllCount();
    int getAllCount2(String sql);

    String[] getCategories();

    String[] getTag();

    List<video> videoCTList(String currentPage,String sql);

    video getVideo(String videoid);

    List<video> getVideoWithAuthor(String authorid);

}
