package com.lihai.biyesheji.mapper;


import com.lihai.biyesheji.domain.TousuTotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TousuTotalMapper {
    // 条件查询按年份
    List<TousuTotal> findall(Integer search);

    //通过时间查找当月记录
    TousuTotal findOne(@Param("year") Integer year, @Param("month") Integer month);

    //更新投诉报表
    boolean update(TousuTotal tousuTotal);

}
