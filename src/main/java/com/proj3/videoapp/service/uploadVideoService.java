package com.proj3.videoapp.service;

import com.proj3.videoapp.entity.preUploadVideo;
import com.proj3.videoapp.entity.preVideo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service
public interface uploadVideoService {
    String uploadVideo(MultipartFile file) throws UnsupportedEncodingException;

    Boolean preUploadSave(Map<String,Object> param);

    preUploadVideo getPreUploadMsg(String cid);

    Boolean submitVideo(preVideo preVideo) throws IOException;

    String saveAndGetVideoCoverImgName(MultipartFile coverImg);

}
