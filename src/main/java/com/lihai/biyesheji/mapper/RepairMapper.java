package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Repair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairMapper {
    // 条件查询报修信息
    List<Repair> findall(String search);
    //新增一个报修单信息
    boolean insertRepair(Repair repair);
    // 根据id删除报修单信息
    boolean deleteRepair(Integer repairId);
    //更新报修单信息
    boolean updateRepair(Repair repair);


    // App用户查询未处理完成的报修记录
    List<Repair> findallNo(Repair repair);

    // App用户查询处理完成的报修记录
    List<Repair> findallYes(Repair repair);

    //根据报修单号查询单个记录
    Repair findOne(Repair repair);

    boolean updateRepairApp(Repair repair);

}
