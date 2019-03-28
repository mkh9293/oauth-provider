package com.mkh.oauthdevelopers.web.rest;

import com.mkh.oauthdevelopers.domain.User;
import com.mkh.oauthdevelopers.service.UserService;
import com.mkh.oauthdevelopers.web.rest.vm.ManagedUserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountResource {
    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    private final UserService userService;

    public AccountResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody ManagedUserVM managedUserVM) {
//        if (!checkPasswordLength(managedUserVM.getPassword())) {
//            throw new InvalidPasswordException();
//        }
        User user = userService.registerUser(managedUserVM, managedUserVM.getPassword());
//        mailService.sendActivationEmail(user);
    }
}
