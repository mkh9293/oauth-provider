package com.mkh.oauthdevelopers.web.rest.vm;

import com.mkh.oauthdevelopers.domain.User;
import com.mkh.oauthdevelopers.service.dto.UserDTO;

import javax.validation.constraints.Size;

public class ManagedUserVM extends UserDTO {
    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUserVM() {}
//    public ManagedUserVM(User user, @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH) String password) {
//        super(user);
//        this.password = password;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ManagedUserVM{" +
                "password='" + password + '\'' +
                '}';
    }
}
