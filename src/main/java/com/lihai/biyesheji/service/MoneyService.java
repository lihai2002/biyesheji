package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Money;

import java.util.List;

public interface MoneyService {
    // 条件查询按年份
    List<Money> findall(Integer search);

    //更新收入报表money
    boolean update(Money money);
}
