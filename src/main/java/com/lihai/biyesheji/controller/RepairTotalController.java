package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.RepairTotal;
import com.lihai.biyesheji.service.RepairTotalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业主维修统计
 */
@RestController
@RequestMapping("/repairTotal")
public class RepairTotalController {
    @Resource
    private RepairTotalService repairTotalService;

    // 条件查询按年份
    @GetMapping("/findall")
    public Result<?> findall(@RequestParam Integer search ){
        List<RepairTotal> findall = repairTotalService.findall(search);
        return Result.success(findall);
    }

    //更新业主维修报表的count
    @PutMapping("/update")
    public Result<?> update(@RequestBody RepairTotal repairTotal){
        boolean update = repairTotalService.update(repairTotal);
        if(update){
            return Result.success();
        }else {
            return Result.error(-1,"更新失败");
        }

    }
}
