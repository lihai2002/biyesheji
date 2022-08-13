package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Money;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MoneyMapper {
    // 条件查询按年份
   List<Money> findall(Integer search);

   //管理员更新收入报表
    boolean update(Money money);

    //app用户更新收入报表
    boolean updateUser(Money money);

    //根据时间查询收入记录
    Money findOne(@Param("year") Integer year,@Param("month") Integer month);


}
