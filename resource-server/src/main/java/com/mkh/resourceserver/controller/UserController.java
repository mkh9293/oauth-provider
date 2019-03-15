package com.mkh.resourceserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class UserController {

    @RequestMapping("/")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

}
