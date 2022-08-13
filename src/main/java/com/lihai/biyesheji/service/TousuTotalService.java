package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.TousuTotal;

import java.util.List;

public interface TousuTotalService {
    // 条件查询按年份
    List<TousuTotal> findall(Integer search);

    //更新投诉报表
    boolean update(TousuTotal tousuTotal);
}
