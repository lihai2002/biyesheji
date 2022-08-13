package com.lihai.biyesheji.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.lihai.biyesheji.domain.Order;
import com.lihai.biyesheji.domain.OrderImport;
import com.lihai.biyesheji.mapper.OrderImportMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/orderImport")
public class OrderImportController {
    @Resource
    private OrderImportMapper orderImportMapper;

    //    批量导入账单
    @PostMapping("/importOrder")
    public void importOrder(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();    //从文件对象获取到InputStream
        ExcelReader reader = ExcelUtil.getReader(inputStream);  //读取流数据
        List<OrderImport> list = reader.readAll(OrderImport.class);   //指定实体类用集合接收数据
        importOrder(list);   //插入数据库
    }

    public boolean importOrder(List<OrderImport> list) {
        for (int i=0;i<list.size();i++){
            boolean b = orderImportMapper.insertOrder(list.get(i));
            if (!b){
                return false;
            }
        }
        return false;
    }

}
