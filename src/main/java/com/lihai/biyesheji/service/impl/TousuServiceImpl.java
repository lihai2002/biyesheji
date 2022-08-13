package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Tousu;
import com.lihai.biyesheji.domain.TousuTotal;
import com.lihai.biyesheji.mapper.TousuMapper;
import com.lihai.biyesheji.mapper.TousuTotalMapper;
import com.lihai.biyesheji.service.TousuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Service
public class TousuServiceImpl implements TousuService {
    @Resource
    private TousuMapper tousuMapper;
    @Resource
    private TousuTotalMapper tousuTotalMapper;


    // 条件查询投诉信息
    @Override
    public List<Tousu> findall(String search) {
        List<Tousu> findall = tousuMapper.findall(search);
        return findall;
    }

    // 根据id删除投诉信息
    @Override
    public boolean deleteTousu(Integer tid) {
        boolean b = tousuMapper.deleteTousu(tid);
        return b;
    }

    //更新投诉信息
    @Override
    public boolean updateTousu(Tousu tousu) {
        boolean b = tousuMapper.updateTousu(tousu);
        return b;
    }


//-------------------------------App---------------------------

    // App用户查询全部投诉记录
    @Override
    public List<Tousu> findallApp(Tousu tousu) {
        List<Tousu> tousus = tousuMapper.findallApp(tousu);
        return tousus;
    }

    //用户增加投诉
    @Override
    public boolean tousuAdd(Tousu tousu) {
        java.util.Date utilDate = new java.util.Date();  //获取系统当前时间作为投诉时间
        java.sql.Date Time = new java.sql.Date(utilDate.getTime());  //将util.Date转化为sql.Date
        tousu.setTousuTime(Time);   //设置投诉时间
        tousu.setReplyState("未回复");     //默认为未回复状态

        Calendar calendar = Calendar.getInstance(); //通过Calendar类的实例对象来获取年月
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH)+1;
        TousuTotal oneTousuTotal = tousuTotalMapper.findOne(year, month);   ////查找到当前月的投诉记录
        Integer count = oneTousuTotal.getCount();   //获取当月投诉次数
        count = count+1;    //投诉次数加1
        oneTousuTotal.setCount(count);
        tousuTotalMapper.update(oneTousuTotal); //更新数据库

        boolean b = tousuMapper.tousuAdd(tousu);
        return b;
    }
}
