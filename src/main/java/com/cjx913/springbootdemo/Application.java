package com.cjx913.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//SpringBoot主程序
@SpringBootApplication
//告诉Spring 哪个packages 的用注解标识的类 会被spring自动扫描并且装入bean容器。
@ComponentScan(basePackages = "com.cjx913.springbootdemo")
public class Application {

    //主程序入口
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
