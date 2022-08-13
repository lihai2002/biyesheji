package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Parking;
import com.lihai.biyesheji.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Resource
    private ParkingService parkingService;

    //    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam String search){
        List<Parking> findall = parkingService.findall(search);
        return Result.success(findall);
    }

    //    查询空车位
    @GetMapping("/findkong")
    public Result<?> findKong(){
        List<Parking> findall = parkingService.findallKong();
        return Result.success(findall);
    }

    //    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody Parking parking){
        boolean a = parkingService.insertparking(parking);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"新增失败");
        }
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="pid") Integer pid){
        boolean a = parkingService.deleteparking(pid);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"删除失败");
        }
    }


    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Parking parking){
        boolean a = parkingService.updateparking(parking);
        if (a){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }


}
