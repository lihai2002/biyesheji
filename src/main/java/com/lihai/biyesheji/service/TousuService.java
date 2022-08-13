package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Repair;
import com.lihai.biyesheji.domain.Tousu;

import java.util.List;

public interface TousuService {

    // 条件查询投诉信息
    List<Tousu> findall(String search);

    // 根据id删除投诉信息
    boolean deleteTousu(Integer tid);

    //更新投诉信息
    boolean updateTousu(Tousu tousu);

//------------------------------------App--------------------------------------

    // App用户查询全部投诉记录
    List<Tousu> findallApp(Tousu tousu);

    //用户增加投诉
    boolean tousuAdd(Tousu tousu);
}
