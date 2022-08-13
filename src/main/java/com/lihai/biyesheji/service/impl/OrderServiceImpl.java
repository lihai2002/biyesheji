package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Money;
import com.lihai.biyesheji.domain.Order;
import com.lihai.biyesheji.domain.Room;
import com.lihai.biyesheji.domain.User;
import com.lihai.biyesheji.mapper.MoneyMapper;
import com.lihai.biyesheji.mapper.OrderMapper;
import com.lihai.biyesheji.mapper.RoomMapper;
import com.lihai.biyesheji.mapper.UserMapper;
import com.lihai.biyesheji.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserMapper userMapper;    //用户
    @Resource
    private MoneyMapper moneyMapper;  //收入统计
    @Resource
    private RoomMapper roomMapper;  //房屋

    // 条件查询电费账单
    @Override
    public List<Order> findallDian(String search) {
            List<Order> findall = orderMapper.findallDian(search);
            return findall;

    }

    // 条件查询欠费电费账单
    @Override
    public List<Order> findallDianNo(String search) {
        List<Order> findall = orderMapper.findallDianNo(search);
        return findall;
    }


    // 条件查询水费账单
    @Override
    public List<Order> findallWater(String search) {
        List<Order> findall = orderMapper.findallWater(search);
        return findall;

    }
    // 条件查询欠费水费账单
    @Override
    public List<Order> findallWaterNo(String search) {
        List<Order> findall = orderMapper.findallWaterNo(search);
        return findall;
    }

    // 条件查询燃气费账单
    @Override
    public List<Order> findallRanQi(String search) {
        List<Order> findall = orderMapper.findallRanQi(search);
        return findall;

    }
    // 条件查询欠费燃气费账单
    @Override
    public List<Order> findallRanQiNo(String search) {
        List<Order> findall = orderMapper.findallRanQiNo(search);
        return findall;
    }

    // 条件查询物业费账单
    @Override
    public List<Order> findallWuYe(String search) {
        List<Order> findall = orderMapper.findallWuYe(search);
        return findall;

    }
    // 条件查询欠费物业费账单
    @Override
    public List<Order> findallWuYeNo(String search) {
        List<Order> findall = orderMapper.findallWuYeNo(search);
        return findall;
    }

    //新增一个账单
    @Override
    public boolean insertOrder(Order order) {
        if(order.getOrderState() == null){
            order.setOrderState("未缴费");
        }
        boolean b = orderMapper.insertOrder(order);
        return b;
    }


    //一键生成物业账单，根据房屋面积计算物业费
    @Override
    public boolean produceOrderWuyeAll(String produceTime,String orderName, Double danJia) {
        List<User> allUser = userMapper.findall("");    //查询所有用户
        User user = new User();
        Order order = new Order();
        for (int i=0;i<allUser.size();i++){
            user = allUser.get(i);  //遍历得到用户
            Room room = roomMapper.findOneUid(user.getUid());   //查找房间
            Integer area = room.getArea();
            Double wuyeMoney = danJia * area;   //计算物业费
            order.setUid(user.getUid());   //用户id
            order.setProduceTime(produceTime);  //账单产生时间
            order.setOrderName(orderName);      //账单类型
            order.setOrderMoney(wuyeMoney);     //账单费用
            order.setOrderState("未缴费");     //默认为未缴费状态
            boolean b = orderMapper.insertOrder(order);//插入到数据库
            if (!b){
                return false;
            }
        }
        return true;
    }


    // 根据id删除账单
    @Override
    public boolean deleteOrder(Integer oid) {
        boolean b = orderMapper.deleteOrder(oid);
        return b;
    }


    //更新账单信息
    @Override
    public boolean updateOrder(Order order) {
        if(order.getOrderState().equals("已缴费")){
            User oneUser = userMapper.findOne( order.getUid()); //根据前端端传来用户id查询到用户
            Double money = oneUser.getMoney();  //获取到该用户的账户余额
            if (money > order.getOrderMoney() || money.equals(order.getOrderMoney())){  //判断余额否大于账单金额
                money = money - order.getOrderMoney();  //扣费
                Date payTime = order.getPayTime();  //获取到支付时间
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(payTime);
                int year = calendar.get(Calendar.YEAR);     //获取年
                int month = calendar.get(Calendar.MONTH)+1;   //获取月
                System.out.println("支付时间："+payTime);
                System.out.println("年"+year);
                System.out.println("月"+month);
                Money oneMoneyTotal = moneyMapper.findOne(year, month); //查找到当前月的总收入记录
                Double moneyTotal = oneMoneyTotal.getMoney();   //获得当前月的总收入
                moneyTotal = moneyTotal+order.getOrderMoney();     //总收入增加
                oneMoneyTotal.setMoney(moneyTotal);
                moneyMapper.update(oneMoneyTotal);  //更新数据库总收入增加
                userMapper.updateMoney(money,order.getUid()); //更新数据库余额
            }

        }
        boolean b = orderMapper.updateOrder(order);
        return b;
    }

//-------------------------------------App------------------------------------------------

    //App用户查询全部欠费账单
    @Override
    public List<Order> findallAppW(Order order) {
        List<Order> orders = orderMapper.findallAppW(order);
        return orders;
    }

    //App用户查询全部已缴费账单
    @Override
    public List<Order> findallAppY(Order order) {
        List<Order> orders = orderMapper.findallAppY(order);
        return orders;
    }


    //   App用户 缴费
    @Override
    public boolean jiaofei(Order order){
        Order oneOrder = orderMapper.findOneUid(order); //查找对应账单
        Double orderMoney = oneOrder.getOrderMoney();  //获取账单金额
        Integer uid = order.getUid();   //获取移动端传来用户id
        User oneUser = userMapper.findOne(uid); //根据移动端传来用户id查询到用户
        Double money = oneUser.getMoney();  //获取到该用户的账户余额
        if (money > orderMoney || money.equals(orderMoney)){
           Double money1 = money - orderMoney;  //扣费
            oneOrder.setOrderState("已缴费");      //更新账单缴费状态

            java.util.Date utilDate = new java.util.Date();  //获取系统当前时间作为支付时间
            java.sql.Date payTime = new java.sql.Date(utilDate.getTime());  //将util.Date转化为sql.Date

            Calendar calendar = Calendar.getInstance(); //通过Calendar类的实例对象来获取年月
            Integer year = calendar.get(Calendar.YEAR);
            Integer month = calendar.get(Calendar.MONTH)+1;

            Money oneMoneyTotal = moneyMapper.findOne(year, month); //查找到当前月的总收入记录
            Double moneyTotal = oneMoneyTotal.getMoney();   //获得当前月的总收入
            moneyTotal = moneyTotal+orderMoney;     //总收入增加
            oneMoneyTotal.setMoney(moneyTotal);
            moneyMapper.update(oneMoneyTotal);  //更新数据库总收入增加

            oneOrder.setPayTime(payTime);   //存入支付时间
            orderMapper.updateOrder(oneOrder);

            userMapper.updateMoney(money1,uid); //更新数据库余额
            return true;
        }else {
            return false;
        }
    }




}
