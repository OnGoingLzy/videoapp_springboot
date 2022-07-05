package com.proj3.videoapp.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Data
public class preVideo {
    private String cid;
    private MultipartFile coverImg;
    private String videoname;
    private String category ;
    private String tagResult;
    private String videoPath;
    private String description;

    public preVideo(String cid, MultipartFile coverImg, String videoname, String category, String tagResult, String videoPath, String description) {
        this.cid = cid;
        this.coverImg = coverImg;
        this.videoname = videoname;
        this.category = category;
        this.tagResult = tagResult;
        this.videoPath = videoPath;
        this.description = description;
    }
}
