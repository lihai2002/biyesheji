package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Parking;

import java.util.List;

public interface ParkingService {
    // 条件查询
    List<Parking> findall(String search);

    // 条件查询
    List<Parking> findallKong();
    //新增一个车位信息
    boolean insertparking(Parking parking);
    // 根据id删除车位
    boolean deleteparking(Integer pid);
    //更新车位信息
    boolean updateparking(Parking parking);
}
