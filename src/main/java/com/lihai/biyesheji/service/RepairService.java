package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Repair;

import java.util.List;

public interface RepairService {
    // 条件查询报修信息
    List<Repair> findall(String search);

    // 根据id删除报修单信息
    boolean deleteRepair(Integer repairId);
    //更新报修单信息
    boolean updateRepair(Repair repair);


//---------------------------------------App------------------------------------------------------------------------

    //App用户新增一个报修单信息
    boolean insertRepair(Repair repair);

    // App用户查询未处理完成的报修记录
    List<Repair> findallNo(Repair repair);

    //App用户完成报修付款
    boolean pay(Repair repair);

    // App用户查询处理完成的报修记录
    List<Repair> findallYes(Repair repair);
}
