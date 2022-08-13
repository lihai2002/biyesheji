package com.lihai.biyesheji.service.impl;


import com.lihai.biyesheji.domain.Building;
import com.lihai.biyesheji.domain.Community;
import com.lihai.biyesheji.mapper.BuildingMapper;
import com.lihai.biyesheji.mapper.CommunityMapper;
import com.lihai.biyesheji.service.BuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Resource
    private BuildingMapper buildingMapper;
    @Resource
    private CommunityMapper communityMapper;


    // 条件查询
    @Override
    public List<Building> findall(Integer search) {
        List<Building> findall = buildingMapper.findall(search);
        return findall;
    }
    //新增楼栋
    @Override
    public boolean insertBuilding(Building building) {
        boolean b = buildingMapper.insertBuilding(building);
        List<Building> buildings = buildingMapper.findallCommunityId(building.getCommunityId()); //根据小区id查询楼栋数量
        int size = buildings.size();
        Community community = communityMapper.findOneCommunityId(building.getCommunityId());//根据id查找小区
        community.setBuildingTotal(size);
        communityMapper.update(community);  //更新小区楼栋数量
        return b;
    }

    // 根据id删除
    @Override
    public boolean deleteBuilding(Integer buildId) {
        Building building = buildingMapper.findBuildId(buildId);   //查找到对应楼栋
        boolean b = buildingMapper.deleteBuilding(buildId);
        List<Building> buildings = buildingMapper.findallCommunityId(building.getCommunityId());    //根据小区id楼栋数量
        int size = buildings.size();
        Community community = communityMapper.findOneCommunityId(building.getCommunityId());//根据id查找小区
        community.setBuildingTotal(size);
        communityMapper.update(community);  //更新小区楼栋数量
        return b;
    }

    //更新
    @Override
    public boolean updateBuilding(Building building) {
        boolean b = buildingMapper.updateBuilding(building);
        return b;
    }

}
