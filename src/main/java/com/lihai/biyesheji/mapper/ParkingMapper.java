package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Parking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingMapper {

    // 条件查询
    List<Parking> findall(String search);

    // 条件查询空车位
    List<Parking> findallKong();
    //新增一个车位信息
    boolean insertparking(Parking parking);
    // 根据id删除车位
    boolean deleteparking(Integer pid);
    //更新车位信息
    boolean updateparking(Parking parking);
}
