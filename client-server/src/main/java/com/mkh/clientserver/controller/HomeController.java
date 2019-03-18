package com.mkh.clientserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/implicit")
    public String implicit() {
        return "implicit";
    }
}
