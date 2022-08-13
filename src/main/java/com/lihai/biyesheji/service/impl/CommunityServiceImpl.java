package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Community;
import com.lihai.biyesheji.mapper.CommunityMapper;
import com.lihai.biyesheji.service.CommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Resource
    private CommunityMapper communityMapper;

    // 查找所有小区
    @Override
    public List<Community> findall() {
        List<Community> findall = communityMapper.findall();
        return findall;
    }

    //    更新小区资料
    @Override
    public boolean update(Community community) {
        boolean update = communityMapper.update(community);
        return update;
    }

    // 根据id删除小区
    @Override
    public boolean delete(Integer communityId) {
        boolean delete = communityMapper.delete(communityId);
        return delete;
    }

}
