package com.proj3.videoapp.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
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
}
