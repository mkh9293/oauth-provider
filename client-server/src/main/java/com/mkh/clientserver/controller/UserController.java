package com.mkh.clientserver.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${config.oauth2.resourceUri}")
    private String resourceUri;

    @Autowired
    private OAuth2RestOperations restTemplate;

    @RequestMapping("/")
    public JsonNode home(){
        return restTemplate.getForObject(resourceUri, JsonNode.class);
    }


}
