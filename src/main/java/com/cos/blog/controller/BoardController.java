package com.cos.blog.controller;

import com.cos.blog.auth.PrincipalDetail;
import com.cos.blog.model.Board;
import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String index(Model model, @PageableDefault(size = 3, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {

        model.addAttribute("boards", boardService.boardList(pageable));
        return "index";
    }

    @GetMapping("/board/save")
    public String save(){
        System.out.println("here is  page of board wirte");
        return "board/saveForm";
    }

    @GetMapping("/board/{id}")
    public String view(@PathVariable("id") int id, Model model ) {
        model.addAttribute("board", boardService.boardView(id) );
        return "board/viewForm";
    }

    @DeleteMapping("/board/{id}")
    public int delete(@PathVariable("id") int id ) {
        boardService.boardDelete(id) ;
    return 1;
    }
}
