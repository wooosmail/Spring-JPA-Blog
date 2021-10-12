package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.function.Supplier;

@RestController

public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/dummy/join2")
    public String join2(@RequestBody Member m) {

        System.out.println(m.getEmail() + " : " + m.getUsername());
    // JPARepository 생성시 <User, Integer> 라 오류
    //    userRepository.save(m);
        return "RequestBody Test for POST";
    }


    @PostMapping("/dummy/join")
    public String join(User u) {
   // public String join(@RequestParam("username") String username, String passwd, String email) {

        System.out.println(u.getUsername());
        System.out.println(u.getPassword());
        System.out.println(u.getEmail());

        userRepository.save(u);
    return "회원가입 완료";
    }

    @PostMapping("/dummy/join3")
    public String join3(@RequestBody User u) {
        // public String join(@RequestParam("username") String username, String passwd, String email) {

        System.out.println(u.getUsername());
        System.out.println(u.getPassword());
        System.out.println(u.getEmail());

        u.setRole(RoleType.ADMIN);
        userRepository.save(u);
        return "회원가입 완료";
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당유저 없음 + " +  id);
            }
        });
        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> list() {

        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> userpage(@PageableDefault(size = 2, sort = "userId", direction = Sort.Direction.DESC
    ) Pageable pageable) {
        Page<User> paginUser = userRepository.findAll(pageable);

        List<User> users = paginUser.getContent();
        return users;
    }

    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User update(@PathVariable int id, @RequestBody User requestUser){

        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("입력된 id 없습니다 "));

        System.out.println(user.toString());
        user.setEmail(requestUser.getEmail());
        user.setPassword(requestUser.getPassword());


    return null;
    }

    @DeleteMapping("/dummy/user/{id}")
    private String delete(@PathVariable int id) {
        System.out.println(
                id
        );

        userRepository.deleteById(id);

    return "삭제 완료";
    }
}
