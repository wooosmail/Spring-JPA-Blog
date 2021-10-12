package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    //@Autowired
    //HttpSession httpSession;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {


        int result = userService.joinService(user);

        System.out.println("호출됨");
    return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
    }

    /*
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user) {


        User principal = userService.loginService(user);

        if(principal != null){
            httpSession.setAttribute("principal", principal);
        }

        System.out.println("호출됨");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    */

}
