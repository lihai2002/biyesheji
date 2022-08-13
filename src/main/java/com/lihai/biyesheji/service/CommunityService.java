package com.lihai.biyesheji.service;


import com.lihai.biyesheji.domain.Community;

import java.util.List;

public interface CommunityService {
    // 查找所有小区
    List<Community> findall();

    //    更新小区资料
    boolean update(Community community);

    // 根据id删除小区
    boolean delete(Integer communityId);

}
