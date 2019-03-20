package com.mkh.clientserver.controller;

import com.mkh.clientserver.util.RequestOauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${config.oauth2.resourceUri}")
    private String resourceUri;

    @Autowired
    private OAuth2RestOperations restTemplate;


    @RequestMapping("/")
    public String home(@RequestParam String code){
        return RequestOauth.requestOauth("authorization_code", code);
    }

    @RequestMapping("/client_credentials")
    public String credentials() {
        return RequestOauth.requestOauth("client_credentials");
    }

    @PostMapping("/passwordGrant")
    public String passwordGrant(@RequestParam String name, @RequestParam String pass) {
        return RequestOauth.requestOauth("password", name, pass);
    }

    @PostMapping("/refreshToken")
    public String refreshToken(@RequestParam String token) {
        return RequestOauth.requestOauth("refreshToken", token);
    }

}
