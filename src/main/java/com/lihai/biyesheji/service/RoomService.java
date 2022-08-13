package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Building;
import com.lihai.biyesheji.domain.Room;

import java.util.List;

public interface RoomService {
    // 条件查询
    List<Room> findall(Integer search);
    // 条件查询未入住的房间
    List<Room> findallNo(Integer search);
    //新增一个房屋信息
    boolean insertRoom(Room room);
    // 根据id删除房屋信息
    boolean deleteRoom(Integer id);
    //更新房屋信息
    boolean updateRoom(Room room);
    //导入
    boolean importRoom(List<Room> list);
}
