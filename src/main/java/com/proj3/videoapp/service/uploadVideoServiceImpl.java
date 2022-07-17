package com.proj3.videoapp.service;

import com.proj3.videoapp.Dao.VideoDao;
import com.proj3.videoapp.entity.preUploadVideo;
import com.proj3.videoapp.entity.preVideo;
import com.proj3.videoapp.uitl.VideoUtil;
import com.proj3.videoapp.uitl.encodeToGB2312;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Service(value = "uploadVideoService")
public class uploadVideoServiceImpl implements uploadVideoService{
    @Autowired
    VideoDao videoDao;
    @Override
    public String uploadVideo(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        System.out.print("上传的文件名为: "+fileName+"\n");
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        String regExp="[\n`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        fileName = fileName.replaceAll(regExp,"");
        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: "+fileName+"\n");
        String path = "F:/学习/videoapp/src/main/resources/static/video/" +fileName;
        //创建文件路径
        File dest = new File(path);
        try {
            file.transferTo(dest); //保存文件

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("保存文件路径"+path+"\n");
        return fileName;
    }

    @Override
    public Boolean preUploadSave(Map<String,Object> param) {
        String cid = (String) param.get("cid");
        String videourl = (String) param.get("videoUrl");
        String videoSize = (String) param.get("videoSize");
        String sql = "insert into preuploadvideo (cid,videourl,uploadstate,videosize) values("+cid+",'"+videourl+"','true','"+videoSize+"')";
        Boolean saveResult =  videoDao.InsertSql(sql);
        return saveResult;
    }

    @Override
    public preUploadVideo getPreUploadMsg(String cid) {
        String sql = "select * from preuploadvideo where cid = '" + cid + "'";
        return videoDao.selectPreUploadVideo(sql);
    }

    @Override
    public Boolean submitVideo(preVideo preVideo) throws IOException {

        String videoPath = preVideo.getVideoPath();
        String path =  videoPath.replace("http://localhost:9000/video/","F:/学习/videoapp/src/main/resources/static/video/");
        long videoseconds =  VideoUtil.getMp4Duration(path);
        String coverpath="defaultCover2.png";
        if(!preVideo.getCoverImg().getOriginalFilename().equals("defaultCover2.png")){
            coverpath = saveAndGetVideoCoverImgName(preVideo.getCoverImg());
        }
        String sql = "insert into video (authorid,videoname,videopath,videoseconds,status,createtime,tag,category,description,coverpath) values("+preVideo.getCid()+",'"+preVideo.getVideoname()+"','"+videoPath+"',"+videoseconds+",1,CURRENT_TIMESTAMP,'"+preVideo.getTagResult()+"','"+preVideo.getCategory()+"','"+preVideo.getDescription()+"','"+coverpath+"')";
        Boolean result =  videoDao.InsertSql(sql);
        //删除prevideo表中数据
        sql = "delete from preuploadvideo where cid = '"+preVideo.getCid()+"'";
        Boolean result2 = videoDao.deleteData(sql);
        return result&&result2;
    }

    @Override
    public String saveAndGetVideoCoverImgName(MultipartFile coverImg) {
        String imgName = coverImg.getOriginalFilename();
        //含有特殊字符无法访问
        String regExp="[\n`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        imgName = imgName.replaceAll(regExp,"");
        System.out.print("上传的文件名为: "+imgName+"\n");
        imgName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + imgName;

        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的封面名为: "+imgName+"\n");
        String path = "F:/学习/videoapp/src/main/resources/static/videoCover/" +imgName;
        //创建文件路径
        File dest = new File(path);
        try {
            coverImg.transferTo(dest); //保存文件

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("保存文件路径"+path+"\n");
        return imgName;
    }


}
