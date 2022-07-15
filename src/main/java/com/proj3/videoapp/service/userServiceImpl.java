package com.proj3.videoapp.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("userService")
public class userServiceImpl implements userService{
    @Override
    public String uploadfile(MultipartFile file,String type) {
        String fileName = file.getOriginalFilename();
        System.out.print("上传的名为: "+fileName+"\n");
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        String regExp="[\n`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        fileName = fileName.replaceAll(regExp,"");
        System.out.print("（加个时间戳，尽量避免名称重复）保存的名为: "+fileName+"\n");
        String path = "F:/学习/videoapp/src/main/resources/static/"+type+"/" +fileName;
        //创建文件路径
        File dest = new File(path);
        try {
            file.transferTo(dest); //保存文件

        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        System.out.print("保存路径"+path+"\n");
        return fileName;

    }
}
