package com.cos.blog.controller.api;

import com.cos.blog.auth.PrincipalDetail;
import com.cos.blog.model.Board;
import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    BoardService boardService;

    @PostMapping("/board/saveProc")
    private int save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {

    return  boardService.boardService(board, principalDetail.getUser());

    }
}
