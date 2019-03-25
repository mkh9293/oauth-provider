package com.mkh.resourceserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
public class UserController {

    @RequestMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    @RequestMapping("/resource1")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Principal getResource(Principal principal) {
        return principal;
    }

}
