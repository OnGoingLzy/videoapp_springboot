package com.proj3.videoapp.Dao;

import com.proj3.videoapp.entity.user;
import com.proj3.videoapp.entity.userMsg;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserDao {
    @Select({"select * from user where email='${email}' and cpwd='${cpwd}' "})
    public user getUserByMassage(@Param("email") String email, @Param("cpwd") String cpwd);
    @Select({"select * from usermsgimg where cid = '${cid}'"})
    public userMsg getUserAvatar(@Param("cid") String cid);
    @Update({"${sql}"})
    public Boolean updateSql(@Param("sql")String sql);
    @Insert({"${sql}"})
    public Boolean insertSql(@Param("sql")String sql);
}
