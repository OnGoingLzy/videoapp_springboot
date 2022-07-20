package com.proj3.videoapp.Dao;

import com.proj3.videoapp.entity.favorFolder;
import com.proj3.videoapp.entity.video;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShoucangDao {
    @Select({"select * from favorfolder where ownerid = '${cid}'"})
    public List<favorFolder> getFolder(@Param("cid") String cid);
    @Select({"${sql}"})
    public List<video> selectVideo(@Param("sql") String sql);
    @Insert({"${sql}"})
    public Boolean insertSql(@Param("sql")String sql);
    @Delete({"${sql}"})
    public Boolean deleteSql(@Param("sql") String sql)  ;
    @Update({"${sql}"})
    public Boolean updateSql(@Param("sql") String sql);

}
