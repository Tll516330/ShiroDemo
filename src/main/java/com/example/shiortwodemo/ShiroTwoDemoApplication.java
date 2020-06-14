package com.example.shiortwodemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author tll
 * @date 2020/06/11
 * 需要开启注解扫描
 */
@SpringBootApplication
@MapperScan("com.example.shiortwodemo.mapper")
public class ShiroTwoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroTwoDemoApplication.class, args);
    }

}
