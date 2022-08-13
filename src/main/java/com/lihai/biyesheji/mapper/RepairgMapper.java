package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Repairg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairgMapper {

    // 条件查询维修信息
    List<Repairg> findall(String search);
    //新增一个维修信息
    boolean insertRepairg(Repairg repairg);
    // 根据id删除维修信息
    boolean deleteRepairg(Integer repairgId);
    //更新维修信息
    boolean updateRepairg(Repairg repairg);
}
