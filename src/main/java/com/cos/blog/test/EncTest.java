package com.cos.blog.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncTest {
    @Test
    public void 해쉬_암호화() {
        String encode = new BCryptPasswordEncoder().encode("1234");
        System.out.println(" Encode : " + encode);
    }
}
