package com.proj3.videoapp.entity;

import lombok.Data;

@Data
public class preUploadVideo {
    private Integer cid;
    private String videourl;
    private String uploadstate;
    private String videosize;
}
