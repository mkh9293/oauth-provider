package com.mkh.clientserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/implicit")
    public String implicit() {
        return "implicit";
    }

    @GetMapping("/implicitDone")
    public String implicitDone() {
        return "implicitDone";
    }

    @GetMapping("/authorization")
    public String authorization() {
        return "authorization";
    }

    @GetMapping("/password")
    public String password() {
        return "password";
    }

    @GetMapping("/refresh")
    public String refresh() {
        return "refresh";
    }

}
