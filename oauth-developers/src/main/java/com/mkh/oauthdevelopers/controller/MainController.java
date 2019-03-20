package com.mkh.oauthdevelopers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/setting")
    public String setting() {
        return "setting";
    }
}
