package com.proj3.videoapp.entity;

import lombok.Data;

@Data
public class favorFolder {
    private String ffolderid;
    private String ffoldername;
    private String ownerid;
    private String introduction;
    private Integer limit;

    public favorFolder(String ffolderid, String ffoldername, String ownerid, String introduction, Integer limit) {
        this.ffolderid = ffolderid;
        this.ffoldername = ffoldername;
        this.ownerid = ownerid;
        this.introduction = introduction;
        this.limit = limit;
    }

    public favorFolder(String ffoldername, String ownerid, String introduction, Integer limit) {
        this.ffoldername = ffoldername;
        this.ownerid = ownerid;
        this.introduction = introduction;
        this.limit = limit;
    }
}
