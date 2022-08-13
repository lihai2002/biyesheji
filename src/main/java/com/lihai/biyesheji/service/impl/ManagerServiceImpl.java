package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Manager;
import com.lihai.biyesheji.mapper.ManagerMapper;
import com.lihai.biyesheji.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    //登录
    @Override
    public Manager login(Manager manager) {
        Manager login = managerMapper.login(manager);
        return login;
    }

    //个人信息查询,根据id
    @Override
    public Manager find(Integer managerId) {
        Manager manager = managerMapper.find(managerId);
        return manager;
    }

    //修改个人信息
    @Override
    public boolean update(Manager manager) {
        boolean update = managerMapper.update(manager);
        return update;
    }
}
