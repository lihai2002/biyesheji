package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Repair;
import com.lihai.biyesheji.domain.RepairTotal;
import com.lihai.biyesheji.domain.User;
import com.lihai.biyesheji.mapper.*;
import com.lihai.biyesheji.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Resource
    private RepairMapper repairMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RepairTotalMapper repairTotalMapper;

    // 条件查询报修信息
    @Override
    public List<Repair> findall(String search) {
        List<Repair> findall = repairMapper.findall(search);
        return findall;
    }
    // 根据id删除报修单信息
    @Override
    public boolean deleteRepair(Integer repairId) {
        boolean b = repairMapper.deleteRepair(repairId);
        return b;
    }
    //更新报修单信息
    @Override
    public boolean updateRepair(Repair repair) {
        boolean b = repairMapper.updateRepair(repair);
        return b;
    }


//------------------------------------------APP-----------------------------------------------------------------------------

    //App新增一个报修单信息
    @Override
    public boolean insertRepair(Repair repair) {
        java.util.Date utilDate = new java.util.Date();  //获取系统当前时间作为报修时间
        java.sql.Date time = new java.sql.Date(utilDate.getTime());  //将util.Date转化为sql.Date
        repair.setRepairTime(time);
        repair.setRepairState("未处理");   //默认为未处理状态

        Calendar calendar = Calendar.getInstance(); //通过Calendar类的实例对象来获取年月
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH)+1;
        RepairTotal oneRepairTotal = repairTotalMapper.findOne(year, month);    //查找到当前月的投诉记录
        Integer count = oneRepairTotal.getCount();   //获取当月用户报修次数
        count = count +1;   //报修次数加1
        oneRepairTotal.setCount(count);
        repairTotalMapper.update(oneRepairTotal);   //更新数据库

        boolean b = repairMapper.insertRepair(repair);
        return b;
    }


    // App用户查询未处理完成的报修记录
    @Override
    public List<Repair> findallNo(Repair repair) {
        List<Repair> repairs = repairMapper.findallNo(repair);
        return repairs;
    }

    //App用户完成报修付款
    @Override
    public boolean pay(Repair repair) {
        Repair oneRepair = repairMapper.findOne(repair);  //查找对应报修记录
        Double moneyRepair = oneRepair.getMoney();    //获取维修费用
        Integer uid = oneRepair.getUid();   //获取移动端传来用户id
        User oneUser = userMapper.findOne(uid); //根据移动端传来用户id查询到用户
        Double money = oneUser.getMoney();  //获取到该用户的账户余额
        if(money > moneyRepair|| money == moneyRepair){
           Double  money1 = money - moneyRepair;    //扣费
            userMapper.updateMoney(money1,uid); //更新用户数据库余额

            repair.setRepairState("已处理");     //更新状态
            repairMapper.updateRepairApp(repair);
            return true;
        }else {
            return false;
        }
    }


    // App用户查询处理完成的报修记录
    @Override
    public List<Repair> findallYes(Repair repair) {
        List<Repair> repairs = repairMapper.findallYes(repair);
        return repairs;
    }


}
