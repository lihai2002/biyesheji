package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Money;
import com.lihai.biyesheji.service.MoneyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("money")
public class MoneyController {
    @Resource
    private MoneyService moneyService;

    // 条件查询按年份
    @GetMapping("/findall")
    public Result<?> findall(@RequestParam Integer search ){
        List<Money> findall = moneyService.findall(search);
        return Result.success(findall);
    }

    //更新收入报表的money
    @PutMapping("/update")
    public Result<?> update(@RequestBody Money money){
        boolean update = moneyService.update(money);
        if(update){
            return Result.success();
        }else {
            return Result.error(-1,"更新失败");
        }

    }
}
