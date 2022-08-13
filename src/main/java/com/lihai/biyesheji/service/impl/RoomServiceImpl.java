package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Building;
import com.lihai.biyesheji.domain.Room;
import com.lihai.biyesheji.mapper.BuildingMapper;
import com.lihai.biyesheji.mapper.RoomMapper;
import com.lihai.biyesheji.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomMapper roomMapper;
    @Resource
    private BuildingMapper buildingMapper;


    // 条件查询已入住的房间
    @Override
    public List<Room> findall(Integer search) {
        List<Room> findall = roomMapper.findall(search);
        return findall;
    }

    // 条件查询未入住的房间
    @Override
    public List<Room> findallNo(Integer search) {
        List<Room> list = roomMapper.findallNo(search);
        return list;
    }

    //新增一个房屋信息
    @Override
    public boolean insertRoom(Room room) {
        boolean b = roomMapper.insertRoom(room);
        List<Room> roomList = roomMapper.findallBuildIdYes(room.getBuildId()); //获得对应楼号的已入住的房间数量
        int size = roomList.size();
        Building building = buildingMapper.findBuildId(room.getBuildId());  //查找该楼栋
        building.setRoomYes(size);
        buildingMapper.updateBuilding(building);    //更新该楼栋的已入住户数
        return b;
    }
    // 根据id删除房屋信息
    @Override
    public boolean deleteRoom(Integer id) {
        boolean b = roomMapper.deleteRoom(id);
        return b;
    }
    //更新房屋信息
    @Override
    public boolean updateRoom(Room room) {
        if(room.getState().equals("已入住") && room.getUid() == null){
            room.setUid(room.getUser().getUid());   //user下的用户id赋值给room的用户id,用于判断是否pc端传值
        }
        boolean b = roomMapper.updateRoom(room);
        List<Room> roomList = roomMapper.findallBuildIdYes(room.getBuildId()); //获得对应楼号的已入住的房间数量
        int size = roomList.size();
        System.out.println("楼号："+room.getBuildId());
        System.out.println("楼号已入住："+size);
        Building building = buildingMapper.findBuildId(room.getBuildId());  //查找该楼栋
        building.setRoomYes(size);
        buildingMapper.updateBuilding(building);    //更新该楼栋的已入住户数
        return b;
    }

    //导入
    @Override
    public boolean importRoom(List<Room> list) {
        for (int i=0;i<list.size();i++){
            boolean b = roomMapper.insertRoom(list.get(i));
            if (!b){
                return false;
            }
        }
        return true;
    }


}
