package com.proj3.videoapp.entity;

import lombok.Data;

@Data
public class video {
    private Integer videoid;
    private Integer authorid;
    private String videoname;
    private String videopath;
    private float videoseconds;
    private String coverpath;
    private Integer likescount;
    private Integer status;
    private String createtime;
    private String tag;
    private String category;
    private String description;

}
