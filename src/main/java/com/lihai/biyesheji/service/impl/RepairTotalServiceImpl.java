package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.RepairTotal;
import com.lihai.biyesheji.mapper.RepairTotalMapper;
import com.lihai.biyesheji.service.RepairTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepairTotalServiceImpl implements RepairTotalService {

    @Resource
    private RepairTotalMapper repairTotalMapper;


    // 条件查询按年份
    @Override
    public List<RepairTotal> findall(Integer search) {
        List<RepairTotal> findall = repairTotalMapper.findall(search);
        return findall;
    }

    //更新业主维修报表
    @Override
    public boolean update(RepairTotal repairTotal) {
        boolean update = repairTotalMapper.update(repairTotal);
        return update;
    }
}
