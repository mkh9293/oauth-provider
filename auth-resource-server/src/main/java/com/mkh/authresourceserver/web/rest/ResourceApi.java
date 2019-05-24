package com.mkh.authresourceserver.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ResourceApi {
    @RequestMapping("/validateUser")
    public Principal user(Principal principal){
        return principal;
    }

    @RequestMapping("/api")
    public Principal api(Principal principal){
        return principal;
    }

    @RequestMapping("/users")
    public Principal users(Principal principal){
        return principal;
    }

    @RequestMapping("/simple")
    public Principal simple(Principal principal){
        return principal;
    }
}
