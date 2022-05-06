package com.rest.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainViewController {

    @GetMapping("/")
    public String temp(Model mv) {
        return "main";
    }

    @GetMapping("/test")
    public String main(Model mv) {
        mv.addAttribute("hello", "테스트");
        return "test";
    }

    @GetMapping("/sample")
    public String sample(Model mv) {
        return "sample";
    }

}
