package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(Member m){
        return "get 요청 " + m.getId()  + ", " + m.getUsername() ;
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m){
    //public String postTest(@RequestBody String text){
        return "post 요청 " + m.getId()  + ", " + m.getUsername() + ", " + m.getPasswd() + ", " + m.getEmail() ;
        //   return "post 요청 " + text ;
    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "put 요청 " + m.getId()  + ", " + m.getUsername() + ", " + m.getPasswd() + ", " + m.getEmail() ;

    }

   @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }



}
