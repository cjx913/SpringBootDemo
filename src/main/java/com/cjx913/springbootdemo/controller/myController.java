package com.cjx913.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class myController {
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
