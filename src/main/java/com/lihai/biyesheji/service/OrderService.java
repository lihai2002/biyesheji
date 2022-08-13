package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Order;
import com.lihai.biyesheji.domain.Room;

import java.util.List;

public interface OrderService {

    // 条件查询电费账单
    List<Order> findallDian(String search);

    // 条件查询欠费电费账单
    List<Order> findallDianNo(String search);


    // 条件查询水费账单
    List<Order> findallWater(String search);
    //  条件查询欠费水费账单
    List<Order> findallWaterNo(String search);

    // 条件查询燃气费账单
    List<Order> findallRanQi(String search);
    // 条件查询欠费燃气费账单
    List<Order> findallRanQiNo(String search);

    // 条件查询物业费账单
    List<Order> findallWuYe(String search);
    // 条件查询欠费物业费账单
    List<Order> findallWuYeNo(String search);


    //新增一个账单
    boolean insertOrder(Order order);

//    一键生成物业费账单
    boolean produceOrderWuyeAll(String produceTime,String orderName,Double danJia);

    // 根据id删除账单
    boolean deleteOrder(Integer oid);

    //更新账单信息
    boolean updateOrder(Order order);


//-------------------------------------------------App------------------------------------------

    //app用户查询欠费账单，根据id
    List<Order> findallAppW(Order order);

    //app用户查询全部欠费账单，根据id
    List<Order> findallAppY(Order order);


//    app用户缴费
    boolean jiaofei(Order order);

}
