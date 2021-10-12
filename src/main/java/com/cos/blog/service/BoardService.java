package com.cos.blog.service;

import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public int boardService(Board board, User user) {

        try {

            int cnt = 0;
            board.setCount(cnt);
            board.setUser(user);

            boardRepository.save(board);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(" boardService Err : " + e.getMessage());

        }
        return -1;
    }

    public Page<Board> boardList ( Pageable pageable){

    return boardRepository.findAll(pageable);
    }

    public Board boardView (int id){
        return boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("글 상세 보기 실패"));
    }

    @Transactional
    public void boardDelete(int id) {
        boardRepository.deleteById(id);
    }
    /*
    @Transactional(readOnly = true)
    public User loginService(User user) {

       return   userRepository.findByUsernameAndPasswd(user.getUsername(), user.getPasswd());
    }
     */
}
