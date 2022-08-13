package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.RepairTotal;

import java.util.List;

public interface RepairTotalService {
    // 条件查询按年份
    List<RepairTotal> findall(Integer search);

    //更新业主维修报表
    boolean update(RepairTotal repairTotal);
}
