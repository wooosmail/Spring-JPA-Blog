package com.cos.blog.service;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional
    public int joinService(User user) {

        try {

            String rawPasswd = user.getPassword();
            user.setRole(RoleType.USER);
            user.setPassword(encode.encode(rawPasswd));
            userRepository.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(" joinService Err : " + e.getMessage());

        }

        return -1;
    }

    /*
    @Transactional(readOnly = true)
    public User loginService(User user) {

       return   userRepository.findByUsernameAndPasswd(user.getUsername(), user.getPasswd());
    }
     */
}
