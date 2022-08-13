package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.RepairgTotal;

import java.util.List;

public interface RepairgTotalService {
    // 条件查询按年份
    List<RepairgTotal> findall(Integer search);

    //更新公共维修报表
    boolean update(RepairgTotal repairgTotal);
}
