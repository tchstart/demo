package com.tchstart.controller;

import com.tchstart.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tchstart
 * @data 2024-03-27
 */
@RestController("")
public class UserController {

    @Log("展示用户信息")
    @GetMapping("/listUser")
    public void listUser(){
        System.out.println("展示用户信息");
    }



    @Log("新增用户信息")
    @GetMapping("/addUser")
    public void addUser(){
        System.out.println("模拟新增用户");
    }
}
