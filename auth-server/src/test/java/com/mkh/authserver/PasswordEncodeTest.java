package com.mkh.authserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PasswordEncodeTest {
    @Test
    public void 비밀번호_암호화() {
        BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
        String result = bcr.encode("secret");
        System.out.println("암호 === " + result);
    }
}
