package com.proj3.videoapp.entity;

import lombok.Data;


@Data
public class comment {
    private String commentid;
    private String videoid;
    private String cid;
    private String content;
    private String tocid;
    private String commenttype;
    private String date;
    private Integer belikecounts;

    public comment(String commentid, String videoid, String cid, String content, String tocid, String commenttype, String date, Integer belikecounts) {
        this.commentid = commentid;
        this.videoid = videoid;
        this.cid = cid;
        this.content = content;
        this.tocid = tocid;
        this.commenttype = commenttype;
        this.date = date;
        this.belikecounts = belikecounts;
    }

    public comment(String videoid, String cid, String content, String tocid) {
        this.videoid = videoid;
        this.cid = cid;
        this.content = content;
        this.tocid = tocid;
    }
}
