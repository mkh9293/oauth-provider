package com.mkh.oauthdevelopers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/setting")
    public String setting() {
        return "setting";
    }
}
