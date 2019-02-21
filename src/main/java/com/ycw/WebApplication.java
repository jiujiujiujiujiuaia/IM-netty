package com.ycw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author yuchunwei
 */
@SpringBootApplication
//@ComponentScan({"com.blog"})
//@ServletComponentScan
@MapperScan(basePackages = "com.ycw.Mobilewechat.mapper")
@EnableAutoConfiguration
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}   
