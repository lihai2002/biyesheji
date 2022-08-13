package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Repair;
import com.lihai.biyesheji.service.RepairService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Resource
    private RepairService repairService;


    //    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam String search){
        List<Repair> findall = repairService.findall(search);
        return Result.success(findall);
    }


    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="repairId") Integer repairId){
        repairService.deleteRepair(repairId);
        return Result.success();
    }

    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Repair user){
        boolean b = repairService.updateRepair(user);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }


//--------------------------------------------App--------------------------------------------
    //app用户申请报修
    @PostMapping("/repairAdd")
    public Result<?> repairAdd(@RequestBody Repair repair){
        boolean b = repairService.insertRepair(repair);
        if(b){
            return Result.success();
        }else {
            return Result.error(-1,"申请报修失败");
        }

    }

    //App用户查询未处理完成的报修记录
    @PostMapping("/findallNo")
    public Result<?> findallNo(@RequestBody Repair repair){
        List<Repair> findall = repairService.findallNo(repair);
        return Result.success(findall);
    }

    //App用户查询处理完成的报修记录
    @PostMapping("/findallYes")
    public Result<?> findallYes(@RequestBody Repair repair){
        List<Repair> findall = repairService.findallYes(repair);
        return Result.success(findall);
    }

    //App用户完成报修付款
    @PostMapping("/pay")
    public Result<?> pay(@RequestBody Repair repair){
        boolean pay = repairService.pay(repair);
        if (pay){
            return Result.success();
        }else {
            return Result.error(-1,"余额不足,支付失败");
        }

    }

}
