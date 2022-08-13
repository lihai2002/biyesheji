package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Money;
import com.lihai.biyesheji.domain.TousuTotal;
import com.lihai.biyesheji.service.TousuTotalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *投诉统计报表
 */
@RestController
@RequestMapping("/tousuTotal")
public class TousuTotalController {
    @Resource
    private TousuTotalService tousuTotalService;

    // 条件查询按年份
    @GetMapping("/findall")
    public Result<?> findall(@RequestParam Integer search ){
        List<TousuTotal> findall = tousuTotalService.findall(search);
        return Result.success(findall);
    }

    //更新投诉报表的count
    @PutMapping("/update")
    public Result<?> update(@RequestBody TousuTotal tousuTotal){
        boolean update = tousuTotalService.update(tousuTotal);
        if(update){
            return Result.success();
        }else {
            return Result.error(-1,"更新失败");
        }

    }
}
