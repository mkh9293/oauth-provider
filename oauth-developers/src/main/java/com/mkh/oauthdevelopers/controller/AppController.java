package com.mkh.oauthdevelopers.controller;

import com.mkh.oauthdevelopers.domain.App;
import com.mkh.oauthdevelopers.service.AppService;
import com.mkh.oauthdevelopers.service.dto.AppDTO;
import com.mkh.oauthdevelopers.service.util.SecureUtil;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/app")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping
    public ResponseEntity<User> createApp(@Valid @RequestParam AppDTO appDTO){

        String uuid = UUID.randomUUID().toString();
        String sha = SecureUtil.encryptSHA256(uuid);

        System.out.println(appDTO);
        App newApp = appService.createApp(appDTO);


        return null;
    }
}
