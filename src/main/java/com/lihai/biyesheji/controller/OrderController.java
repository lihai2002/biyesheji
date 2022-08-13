package com.lihai.biyesheji.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Order;
import com.lihai.biyesheji.domain.Room;
import com.lihai.biyesheji.service.OrderService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    //    查询电费账单
    @GetMapping("/findDian")
    public Result<?> findDian(@RequestParam String search){
        List<Order> findall = orderService.findallDian(search);
        return Result.success(findall);
    }
    //    查询电费欠费账单
    @GetMapping("/findDianNo")
    public Result<?> findDianNo(@RequestParam String search){
        List<Order> findall = orderService.findallDianNo(search);
        return Result.success(findall);
    }

    //    查询水费账单
    @GetMapping("/findWater")
    public Result<?> findallWater(@RequestParam String search){
        List<Order> findall = orderService.findallWater(search);
        return Result.success(findall);
    }
    //    条件查询欠费水费账单
    @GetMapping("/findWaterNo")
    public Result<?> findallWaterNo(@RequestParam String search){
        List<Order> findall = orderService.findallWaterNo(search);
        return Result.success(findall);
    }

    //    条件查询燃气费账单
    @GetMapping("/findRanQi")
    public Result<?> findallRanQi(@RequestParam String search){
        List<Order> findall = orderService.findallRanQi(search);
        return Result.success(findall);
    }
    //    条件查询欠费燃气费账单
    @GetMapping("/findRanQiNo")
    public Result<?> findallRanQiNo(@RequestParam String search){
        List<Order> findall = orderService.findallRanQiNo(search);
        return Result.success(findall);
    }


    //    条件查询物管费账单
    @GetMapping("/findWuYe")
    public Result<?> findallWuYe(@RequestParam String search){
        List<Order> findall = orderService.findallWuYe(search);
        return Result.success(findall);
    }
    //    条件查询欠费物管费账单
    @GetMapping("/findWuYeNo")
    public Result<?> findallWuYeNo(@RequestParam String search){
        List<Order> findall = orderService.findallWuYeNo(search);
        return Result.success(findall);
    }


    //    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody Order order){
        orderService.insertOrder(order);
        return Result.success();
    }

    //一键生成物管费账单
    @GetMapping("/produceOrderWuyeAll")
    public Result<?> produceOrderWuyeAll(@RequestParam String produceTime,@RequestParam String orderName, @RequestParam Double danJia){
        boolean b = orderService.produceOrderWuyeAll(produceTime,orderName, danJia);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"生成账单失败");
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="oid") Integer oid){
        orderService.deleteOrder(oid);
        return Result.success();
    }

    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Order Order){
        boolean b = orderService.updateOrder(Order);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }


    //    打印电费账单
    @GetMapping("/exportDian")
    public void exportDian(HttpServletResponse response) throws IOException {
        List<Order> findall = orderService.findallDian("");    //从数据库查询数据
        ExcelWriter writer = ExcelUtil.getWriter();     //在内存操作，写出到浏览器
        writer.addHeaderAlias("oid","账单号");
        writer.addHeaderAlias("produceTime","账单产生时间");
        writer.addHeaderAlias("orderName","账单名称");
        writer.addHeaderAlias("uid","用户ID");
        writer.addHeaderAlias("orderMoney","费用金额");
        writer.addHeaderAlias("orderState","缴费状态");
        writer.addHeaderAlias("payTime","支付时间");
        writer.setOnlyAlias(true);  //只出加了别名的字段
        writer.write(findall); //将查询结果list中的对象写入Excel
        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("电费账单","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xls");

        OutputStream out = response.getOutputStream();   //通过response对象获取到输出流
        writer.flush(out,true);     //把Excel刷新到输出流里面
        out.close();    //关闭输出流
        writer.close();   //关闭writer

    }

//    打印水费账单
    @GetMapping("/exportWater")
    public void exportWater(HttpServletResponse response) throws IOException {
        List<Order> findall = orderService.findallWater("");    //从数据库查询数据
        ExcelWriter writer = ExcelUtil.getWriter();     //在内存操作，写出到浏览器
        writer.addHeaderAlias("oid","账单号");
        writer.addHeaderAlias("produceTime","账单产生时间");
        writer.addHeaderAlias("orderName","账单名称");
        writer.addHeaderAlias("uid","用户ID");
        writer.addHeaderAlias("orderMoney","费用金额");
        writer.addHeaderAlias("orderState","缴费状态");
        writer.addHeaderAlias("payTime","支付时间");
        writer.setOnlyAlias(true);  //只出加了别名的字段

        writer.write(findall,true); //将查询结果list中的对象写入Excel
        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("水费账单","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xls");

        OutputStream out = response.getOutputStream();   //通过response对象获取到输出流
        writer.flush(out,true);     //把Excel刷新到输出流里面
        out.close();    //关闭输出流
        writer.close();   //关闭writer
    }

    //    打印燃气费账单
    @GetMapping("/exportRanQi")
    public void exportRanQi(HttpServletResponse response) throws IOException {
        List<Order> findall = orderService.findallRanQi("");    //从数据库查询数据
        ExcelWriter writer = ExcelUtil.getWriter();     //在内存操作，写出到浏览器
        writer.addHeaderAlias("oid","账单号");
        writer.addHeaderAlias("produceTime","账单产生时间");
        writer.addHeaderAlias("orderName","账单名称");
        writer.addHeaderAlias("uid","用户ID");
        writer.addHeaderAlias("orderMoney","费用金额");
        writer.addHeaderAlias("orderState","缴费状态");
        writer.addHeaderAlias("payTime","支付时间");
        writer.setOnlyAlias(true);  //只写出加了别名的字段
        writer.write(findall,true); //将查询结果list中的对象写入Excel
        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("燃气费账单","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xls");

        OutputStream out = response.getOutputStream();   //通过response对象获取到输出流
        writer.flush(out,true);     //把Excel刷新到输出流里面
        out.close();    //关闭输出流
        writer.close();   //关闭writer

    }

    //    打印物管费账单
    @GetMapping("/exportWuYe")
    public void exportWuYe(HttpServletResponse response) throws IOException {
        List<Order> findall = orderService.findallWuYe("");    //从数据库查询数据
        ExcelWriter writer = ExcelUtil.getWriter();     //在内存操作，写出到浏览器
        writer.addHeaderAlias("oid","账单号");
        writer.addHeaderAlias("produceTime","账单产生时间");
        writer.addHeaderAlias("orderName","账单名称");
        writer.addHeaderAlias("uid","用户ID");
        writer.addHeaderAlias("orderMoney","费用金额");
        writer.addHeaderAlias("orderState","缴费状态");
        writer.addHeaderAlias("payTime","支付时间");
        writer.setOnlyAlias(true);  //只出加了别名的字段
        writer.write(findall); //将查询结果list中的对象写入Excel
        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("物管费账单","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xls");

        OutputStream out = response.getOutputStream();   //通过response对象获取到输出流
        writer.flush(out,true);     //把Excel刷新到输出流里面
        out.close();    //关闭输出流
        writer.close();   //关闭writer

    }
//------------------------------------------App-----------------------------------------------

//    App查询全部未缴费账单
    @PostMapping("/findAppW")
    public Result<?> findallAppW(@RequestBody Order order){
        List<Order> orders = orderService.findallAppW(order);
        return Result.success(orders);
    }

//    App查询全部已未缴费账单
    @PostMapping("/findAppY")
    public Result<?> findallAppY(@RequestBody Order order){
        List<Order> orders = orderService.findallAppY(order);
        return Result.success(orders);
    }


    //    App缴费
    @PostMapping("/jiaofei")
    public Result<?> jiaofei(@RequestBody Order order){
        boolean jiaofei = orderService.jiaofei(order);
        if (jiaofei){
            return Result.success();
        }else {
            return Result.error(-1,"支付失败，余额不足");
        }
    }

}
