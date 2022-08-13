package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.OrderImport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderImportMapper {

    //新增一个账单
    boolean insertOrder(OrderImport orderImport);
}
