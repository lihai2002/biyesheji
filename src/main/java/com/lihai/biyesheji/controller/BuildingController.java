package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Building;
import com.lihai.biyesheji.service.BuildingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Resource
    private BuildingService buildingService;

    //    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam Integer search){
        List<Building> findall = buildingService.findall(search);
        return Result.success(findall);
    }

    //    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody Building building){
        boolean a = buildingService.insertBuilding(building);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"新增失败");
        }
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="buildId") Integer buildId){
        boolean a = buildingService.deleteBuilding(buildId);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"删除失败");
        }
    }


    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Building building){
        boolean a = buildingService.updateBuilding(building);
        if (a){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }

}
