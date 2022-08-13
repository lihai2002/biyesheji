package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.RepairgTotal;
import com.lihai.biyesheji.domain.TousuTotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RepairgTotalMapper {
    // 条件查询按年份
    List<RepairgTotal> findall(Integer search);

    //通过时间查找当月记录
    RepairgTotal findOne(@Param("year") Integer year, @Param("month") Integer month);

    //更新公共维修报表
    boolean update(RepairgTotal repairgTotal);
}
