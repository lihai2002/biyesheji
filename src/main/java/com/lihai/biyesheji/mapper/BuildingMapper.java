package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Building;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuildingMapper {
    // 条件查询
    List<Building> findall(Integer search);
    // 根据小区号查询楼栋
    List<Building> findallCommunityId(Integer communityId);
    //根据楼栋id查询楼栋
    Building findBuildId(Integer buildId);
    //新增一个
    boolean insertBuilding(Building building);
    // 根据id删除
    boolean deleteBuilding(Integer buildId);
    //更新
    boolean updateBuilding(Building building);
}
