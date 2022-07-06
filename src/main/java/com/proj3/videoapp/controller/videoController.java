package com.proj3.videoapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.proj3.videoapp.entity.preUploadVideo;
import com.proj3.videoapp.entity.preVideo;
import com.proj3.videoapp.entity.video;
import com.proj3.videoapp.service.videoServiceImpl;
import com.proj3.videoapp.service.uploadVideoServiceImpl;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController //只返回值所用
public class videoController {
    private videoServiceImpl videoService;
    private uploadVideoServiceImpl uploadVideoService;

    public videoController(videoServiceImpl videoService,uploadVideoServiceImpl uploadVideoService) {
        this.videoService = videoService;
        this.uploadVideoService = uploadVideoService;
    }
    //分页查询视频
    @RequestMapping("/videoListPage")
    public List<video> videoListPage(@RequestBody() String currentPage) {
        currentPage = currentPage.replace("=","");
        System.out.println("分页查询开始："+currentPage);

        List<video> list = videoService.VideoListPage(String.valueOf(currentPage));
        System.out.println("第一个视频是"+list.get(0).getVideoname());
        return list;
    }
    @RequestMapping("/getMaxPage")
    public Integer getmaxpage() throws SQLException {
        int Maxpage = videoService.getMaxPage();
        return Maxpage;
    }
    //获取所有视频数量
    @RequestMapping("/getAllCount")
    public Integer getallcount(){
        return videoService.getAllCount();
    }
    //有标签，分类的视频总数量
    @RequestMapping("/getAllCount2")
    public Integer getallcount2(@RequestBody Map<String,Object> param){
        String currentPage = (String) param.get("cpage");
        String category = (String) param.get("category");
        ArrayList tag = (ArrayList) param.get("tag");
        String searchSql = (String) param.get("searchSql");
        if(searchSql == null)searchSql="";
        String tagSql="";
        if(category.equals("默认")){
            tagSql = "select * from video where tag LIKE '%默认%'  and status=2 ";
        }else tagSql = "select * from video where category='"+category+"' and tag LIKE '%默认%'  and status=2 ";
        //将标签拆解
        for(int i=0;i<tag.size();i++){
            tagSql = tagSql + " and tag LIKE '%" + tag.get(i) + "%'";
        }
        String resultSql = "select * from ("+tagSql+") as table1 " + searchSql;
        System.out.println("当前视频总数:"+videoService.getAllCount2(resultSql));

        return videoService.getAllCount2(resultSql);
    }
    //获取视频分类
    @RequestMapping("getVideoCategories")
    public List getvideoCategories(){
        List list = Arrays.asList(videoService.getCategories());
        System.out.println(list);
        return list;
    }
    //获取视频标签
    @RequestMapping("getVideoTag")
    public List getVT(){
        List list = Arrays.asList(videoService.getTag());
        System.out.println(list);
        return list;
    }
    //根据筛选信息查找视频
    @RequestMapping("getVideoWithCategoryAndTag")
    public List<video> getVWCAT(@RequestBody Map<String,Object> param){//多数据post用body 用Map存储
        String currentPage = (String) param.get("cpage");
        String category = (String) param.get("category");
        ArrayList tag = (ArrayList) param.get("tag");
        String searchSql = (String) param.get("searchSql");
        if(searchSql == null)searchSql="";
        System.out.println("searchSql: "+searchSql);
        String tagSql="";
        if(category.equals("默认")){
            tagSql = "select * from video where tag LIKE '%默认%' and status=2 ";
        }else tagSql = "select * from video where category='"+category+"' and status=2 and tag LIKE '%默认%'";
        //将标签拆解
        for(int i=0;i<tag.size();i++){
            tagSql = tagSql + " and tag LIKE '%" + tag.get(i) + "%'";
        }

        String resultSql = "select * from ("+tagSql+") as table1 " + searchSql;
        System.out.println(resultSql);
        List<video> videoList = videoService.videoCTList(currentPage,resultSql);
        //测试mybatis分页
//        videoService.mybatisPaginatedQueries(currentPage,resultSql);
        return videoList;
    }
    //获取搜索框的内容，并把它处理成sql语句
    @RequestMapping("searchContent")
    public String searchSql(@RequestBody() String test){
        System.out.println(test);
        String sql = " where videoname like ";
        if(!test.isEmpty()){
            if (test.length()==1) {
                sql = sql +  "'%" + test.charAt(0)+"%'";
                return sql;
            }
            for(int i=0;i<test.length()-1;i++){
                if(test.charAt(i) == ' ') continue;
                if(i==test.length()-2){
                    sql = sql + "'%" + test.charAt(i) + test.charAt(i+1) + "%'";
                }else sql = sql +"'%" + test.charAt(i) + test.charAt(i+1)+ "%' or videoname like ";

            }
        }
        System.out.println(sql);
        return sql;
    }
    //获取点击的视频
   @RequestMapping("getVideo")
   public video getVideo(@RequestBody String videoid){
        videoid = videoid.replace("=","");
        return videoService.getVideo(videoid);
   }
   //获取作者的视频
   @RequestMapping("getVideoWithAuthor")
   public List<video> getVideo2(@RequestBody String authorid){
        authorid = authorid.replace("=","");
        return videoService.getVideoWithAuthor(authorid);
   }
}
