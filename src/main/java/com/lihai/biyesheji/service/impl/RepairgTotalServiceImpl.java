package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.RepairgTotal;
import com.lihai.biyesheji.mapper.RepairgTotalMapper;
import com.lihai.biyesheji.service.RepairgTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepairgTotalServiceImpl implements RepairgTotalService {
    @Resource
    private RepairgTotalMapper repairgTotalMapper;

    // 条件查询按年份
    @Override
    public List<RepairgTotal> findall(Integer search) {
        List<RepairgTotal> findall = repairgTotalMapper.findall(search);
        return findall;
    }

    //更新公共维修报表
    @Override
    public boolean update(RepairgTotal repairgTotal) {
        boolean update = repairgTotalMapper.update(repairgTotal);
        return update;
    }
}
