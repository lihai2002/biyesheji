package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.TousuTotal;
import com.lihai.biyesheji.mapper.TousuTotalMapper;
import com.lihai.biyesheji.service.TousuTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TousuTotalServiceImpl implements TousuTotalService {
    @Resource
    private TousuTotalMapper tousuTotalMapper;

    @Override
    public List<TousuTotal> findall(Integer search) {
        List<TousuTotal> findall = tousuTotalMapper.findall(search);
        return findall;
    }

    @Override
    public boolean update(TousuTotal tousuTotal) {
        boolean update = tousuTotalMapper.update(tousuTotal);
        return update;
    }
}
