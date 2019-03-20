package com.mkh.clientserver.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mkh.clientserver.util.RequestOauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

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

    @RequestMapping("/password")
    public String credentials(@RequestParam String name, @RequestParam String pass) {
        return RequestOauth.requestOauth("password", name, pass);
    }

}
