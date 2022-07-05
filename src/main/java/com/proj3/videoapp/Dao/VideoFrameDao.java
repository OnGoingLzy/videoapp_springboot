package com.proj3.videoapp.Dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface VideoFrameDao {
    @Select({"${sql}"})
    public Boolean checkSql(@Param("sql")String sql);
    @Select({"${sql}"})
    public List<String> checkBeCollectedSql(@Param("sql")String sql);
    @Insert({"${sql}"})
    public Boolean insertSql(@Param("sql") String sql);
    @Delete({"${sql}"})
    public Boolean deleteSql(@Param("sql") String sql);

}
