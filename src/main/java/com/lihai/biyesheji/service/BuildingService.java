package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Building;

import java.util.List;

public interface BuildingService {

    // 条件查询
    List<Building> findall(Integer search);
    //新增一个用户
    boolean insertBuilding(Building building);
    // 根据id删除用户
    boolean deleteBuilding(Integer buildId);
    //更新用户
    boolean updateBuilding(Building building);

}
