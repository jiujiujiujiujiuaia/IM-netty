package com.ycw.im.imsingel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @Author yuchunwei
 */
@SpringBootApplication
//@ComponentScan({"com.blog"})
//@ServletComponentScan
@MapperScan(basePackages = "com.ycw.im.imsingel.Mobilewechat.mapper")
@EnableAutoConfiguration
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}   
