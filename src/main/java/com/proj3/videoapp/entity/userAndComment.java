package com.proj3.videoapp.entity;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public class userAndComment {
    private String cid;
    private String cname;
    private String avatarname;
    private String commentid;
    private String videoid;
    private Integer belikecounts;
    private String content;
    private String tocid;
    private String commenttype;
    private String date;

}
