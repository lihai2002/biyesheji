package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Notice;
import com.lihai.biyesheji.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    // 条件查询电费账单
    List<Order> findallDian(String search);
    // 条件查询电费账单导出
//    List<Order> findallExport(String orderName);

    // 条件查询欠费电费账单
    List<Order> findallDianNo(String search);


    // 条件查询水费账单
    List<Order> findallWater(String search);
    // 条件查询欠费水费账单
    List<Order> findallWaterNo(String search);

    // 条件查询燃气费账单
    List<Order> findallRanQi(String search);
    // 条件查询欠费燃气费账单
    List<Order> findallRanQiNo(String search);

    // 条件查询物管费账单
    List<Order> findallWuYe(String search);
    // 条件查询欠费物管费账单
    List<Order> findallWuYeNo(String search);



    //新增一个账单
    boolean insertOrder(Order order);
    // 根据id删除账单
    boolean deleteOrder(Integer oid);
    //更新账单信息
    boolean updateOrder(Order order);

//----------------------------------------App--------------------------------------------------

    //app用户查询欠费账单，根据id
    List<Order> findallAppW(Order order);

    //app用户查询已缴费账单，根据id
    List<Order> findallAppY(Order order);

    //根据缴费用户id查找该订单
    Order findOneUid(Order order);

}
