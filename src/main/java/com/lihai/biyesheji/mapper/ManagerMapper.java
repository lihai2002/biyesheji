package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository //标识为持久层组件
@Mapper
public interface ManagerMapper{
    //登录
    Manager login(Manager manager);

    //个人信息查询,根据id
    Manager find(Integer managerId);
    //修改个人信息
    boolean update(Manager manager);
}
