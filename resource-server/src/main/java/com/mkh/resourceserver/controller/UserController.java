package com.mkh.resourceserver.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.JsonParseException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;

@RestController
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class UserController {

    @RequestMapping("/")
    public String main() {
        return "123";
    }

    @RequestMapping("/principal")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    @RequestMapping("/user")
    public JsonNode getUser() throws JsonParseException, IOException {
        String str = "{'test':'test1'}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(str);
        return obj;
    }
}
