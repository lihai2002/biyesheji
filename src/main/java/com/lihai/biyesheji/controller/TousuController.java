package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Repair;
import com.lihai.biyesheji.domain.Tousu;
import com.lihai.biyesheji.service.TousuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tousu")
public class TousuController {

    @Resource
    private TousuService tousuService;

    //    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam String search){
        List<Tousu> findall = tousuService.findall(search);
        return Result.success(findall);
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="tid") Integer tid){
        tousuService.deleteTousu(tid);
        return Result.success();
    }


    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Tousu tousu){
        boolean b = tousuService.updateTousu(tousu);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }


//--------------------------------------------App--------------------------------

    //    App查询所有投诉记录
    @PostMapping("/findallApp")
    public Result<?> findallApp(@RequestBody Tousu tousu){
        List<Tousu> tousus = tousuService.findallApp(tousu);
        return Result.success(tousus);
    }

    @PostMapping("/tousuAdd")
    public Result<?> tousuAdd(@RequestBody Tousu tousu){
        boolean b = tousuService.tousuAdd(tousu);
        if (b){
            return Result.success();
        }else {
            return Result.error(-1,"投诉失败");
        }

    }

}
