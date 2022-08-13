package com.lihai.biyesheji.controller;



import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.RepairgTotal;
import com.lihai.biyesheji.service.RepairgTotalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公共维修统计报表
 */
@RestController
@RequestMapping("/repairgTotal")
public class RepairgTotalController {
    @Resource
    private RepairgTotalService repairgTotalService;

    // 条件查询按年份
    @GetMapping("/findall")
    public Result<?> findall(@RequestParam Integer search ){
        List<RepairgTotal> findall = repairgTotalService.findall(search);
        return Result.success(findall);
    }

    //更新公共维修报表的count
    @PutMapping("/update")
    public Result<?> update(@RequestBody RepairgTotal repairgTotal){
        boolean update = repairgTotalService.update(repairgTotal);
        if(update){
            return Result.success();
        }else {
            return Result.error(-1,"更新失败");
        }

    }
}
