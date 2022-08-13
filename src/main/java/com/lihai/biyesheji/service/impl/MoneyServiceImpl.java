package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Money;
import com.lihai.biyesheji.mapper.MoneyMapper;
import com.lihai.biyesheji.service.MoneyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {
    @Resource
    private MoneyMapper moneyMapper;

    // 条件查询按年份
    @Override
    public List<Money> findall(Integer search) {
        List<Money> findall = moneyMapper.findall(search);
        return findall;
    }

    //更新收入报表money
    @Override
    public boolean update(Money money) {
        boolean update = moneyMapper.update(money);
        return update;
    }
}
