package com.proj3.videoapp.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminDao {

    @Update({"${sql}"})
    public Boolean updateSql(@Param("sql") String sql);

}
