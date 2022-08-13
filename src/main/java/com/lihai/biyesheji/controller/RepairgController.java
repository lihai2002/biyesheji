package com.lihai.biyesheji.controller;


import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Repairg;
import com.lihai.biyesheji.service.RepairgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/repairg")
public class RepairgController {

    @Resource
    private RepairgService repairgService;

    //    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam String search){
        List<Repairg> findall = repairgService.findall(search);
        return Result.success(findall);
    }

    //    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody Repairg repairg){
        repairgService.insertRepairg(repairg);
        return Result.success();
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="repairgId") Integer repairgId){
        repairgService.deleteRepairg(repairgId);
        return Result.success();
    }


    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Repairg repairg){
        boolean b = repairgService.updateRepairg(repairg);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }
}
