package com.cos.blog.auth;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDealilService implements UserDetailsService {
    // 스프링이 로그인 요청을 가로챌때 name , paaswd 두개 가로 채는데
    //  passwd 부분 처리는 알아서 함.
    // username 만 db에서 체크
    // test

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자 없음 : "+  username);
                });


        return new PrincipalDetail( principal ) {
        };
    }
}
