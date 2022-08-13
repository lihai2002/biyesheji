package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Manager;

public interface ManagerService {
    //登录
    Manager login(Manager manager);

    //个人信息查询,根据id
    Manager find(Integer managerId);

    //修改个人信息
    boolean update(Manager manager);
}
