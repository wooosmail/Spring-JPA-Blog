package com.cos.blog.config;

import com.cos.blog.auth.PrincipalDealilService;
import com.cos.blog.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IOC 관리
@EnableWebSecurity // 시큐리티 필터 추가
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소접근시 권한 및 인증 미리 체크
public class Securityconfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PrincipalDealilService principalDealilService;

    @Bean // 아래 BCryptP 객체가 IoC가 된다 .?
    public BCryptPasswordEncoder encodePWD() {
    //    String encPasswd = new BCryptPasswordEncoder().encode("1234");
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDealilService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/auth/**", "/js/**", "/css/**","/image/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/auth/loginForm")
                    .loginProcessingUrl("/auth/loginProc")
                    .defaultSuccessUrl("/");
    }
}
