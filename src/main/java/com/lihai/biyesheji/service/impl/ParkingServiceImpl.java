package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Parking;
import com.lihai.biyesheji.mapper.ParkingMapper;
import com.lihai.biyesheji.service.ParkingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Resource
    private ParkingMapper parkingMapper;

    // 条件查询
    @Override
    public List<Parking> findall(String search) {
        List<Parking> findall = parkingMapper.findall(search);
        return findall;
    }

    // 条件查询空车位
    @Override
    public List<Parking> findallKong() {
        List<Parking> findallKong = parkingMapper.findallKong();
        return findallKong;
    }

    //新增一个车位信息
    @Override
    public boolean insertparking(Parking parking) {
        boolean b = parkingMapper.insertparking(parking);
        return b;
    }
    // 根据id删除车位
    @Override
    public boolean deleteparking(Integer pid) {
        boolean b = parkingMapper.deleteparking(pid);
        return b;
    }
    //更新车位信息
    @Override
    public boolean updateparking(Parking parking) {
        boolean b = parkingMapper.updateparking(parking);
        return b;
    }

}
