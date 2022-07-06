package com.proj3.videoapp.Dao;

import com.proj3.videoapp.entity.preUploadVideo;
import com.proj3.videoapp.entity.video;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
@Component
public interface VideoDao {
    //查询从第几条开始后面size条数据
    @Select({"select * from video LIMIT #{currentPage},#{pageSize}"})
    public ArrayList<video> VideoListPage(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);
    //获取视频条数返回int型
    @Select("select count(videoid) pageCount from video")
    public int videoCount();
    //获取视频分类
    @Select("select * from categories")
    public String[] videoCategories();
    //获取视频标签
    @Select("select * from tag")
    public String[] videoTag();

    @Select({"select * from (${sql}) as table2 LIMIT #{currentPage},#{pageSize}"})
    public List<video> videoCTList(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,@Param("sql") String sql);

    @Select({"select count(videoid) pageCount from (${sql}) as table2"})
    public int videoCount2(@Param("sql") String sql);

    @Insert({"${sql}"})
    public Boolean InsertSql(@Param("sql") String sql);

    @Select({"${sql}"})
    public preUploadVideo selectPreUploadVideo(@Param("sql") String sql);

    @Delete({"${sql}"})
    public Boolean deleteData(@Param("sql") String sql);

    @Select({"${sql}"})
    public video getVideo(@Param("sql") String sql);

    @Select({"${sql}"})
    public List<video> getVideoList(@Param("sql") String sql);

//    public Page<video> videoPaginatedQueries(String sql);
}
