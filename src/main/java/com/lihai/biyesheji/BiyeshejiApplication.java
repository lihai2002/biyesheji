package com.lihai.biyesheji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//用于扫描mapper接口所在的包
@MapperScan("com.lihai.biyesheji.mapper")
public class BiyeshejiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiyeshejiApplication.class, args);

    }

}
