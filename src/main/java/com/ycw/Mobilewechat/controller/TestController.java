package com.ycw.Mobilewechat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yuchunwei
 */
@RestController
public class TestController {

    @RequestMapping("/index")
    public String test(){
        return "hello netty";
    }
    public static void main(String[] args) {

    }
}   
