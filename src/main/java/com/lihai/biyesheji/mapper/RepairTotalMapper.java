package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.RepairTotal;
import com.lihai.biyesheji.domain.TousuTotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RepairTotalMapper {
    // 条件查询按年份
    List<RepairTotal> findall(Integer search);

    //更新业主维修报表
    boolean update(RepairTotal repairTotal);

    //通过时间查找当月维修总计记录
    RepairTotal findOne(@Param("year") Integer year, @Param("month") Integer month);
}
