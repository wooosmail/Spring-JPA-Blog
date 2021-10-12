package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class tempContllertest {

    @GetMapping("/http/getjsp")
    public String getTestJsp(){
        return "test" ;
    }

}
