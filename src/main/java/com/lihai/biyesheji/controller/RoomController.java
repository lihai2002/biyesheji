package com.lihai.biyesheji.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Room;
import com.lihai.biyesheji.service.RoomService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Resource
    private RoomService roomService;

    //    查询所有入住房间
    @GetMapping("/find")
    public Result<?> find(@RequestParam Integer search){
        List<Room> findall = roomService.findall(search);
        return Result.success(findall);
    }

    //    查询未入住的房间
    @GetMapping("/findNo")
    public Result<?> findNo(@RequestParam Integer search){
        List<Room> findall = roomService.findallNo(search);
        return Result.success(findall);
    }

    //    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody Room room){
        boolean a = roomService.insertRoom(room);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"新增失败");
        }
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="id") Integer id){
        boolean a = roomService.deleteRoom(id);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"删除失败");
        }
    }


    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Room room){
        boolean a = roomService.updateRoom(room);
        if (a){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }

    //    批量导入房间资料
    @PostMapping("/importRoom")
    public void importRoom(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();    //从文件对象获取到InputStream
        ExcelReader reader = ExcelUtil.getReader(inputStream);  //读取流数据
        List<Room> list = reader.readAll(Room.class);   //指定实体类用集合接收数据
        roomService.importRoom(list);   //插入数据库
    }


}
