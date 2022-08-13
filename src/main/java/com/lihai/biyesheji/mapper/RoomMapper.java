package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {
    // 条件查询
    List<Room> findall(Integer search);
    // 条件查询未入住的房间
    List<Room> findallNo(Integer search);
    //查询所有房间根据楼栋id和已入住状态
    List<Room> findallBuildIdYes(Integer buildId);
    // 条件查询根据用户id
    Room findOneUid(Integer uid);
    //根据楼号和房间号查询房间
    Room findOneBuildIdRoomId(@Param("buildId") Integer buildId,@Param("roomId") Integer roomId);
    //新增一个房屋信息
    boolean insertRoom(Room room);
    // 根据id删除房屋信息
    boolean deleteRoom(Integer id);
    //更新房屋信息
    boolean updateRoom(Room room);


}
