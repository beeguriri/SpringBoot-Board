package com.example.boardproject.controller;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/addComment")
    public String addComment(@AuthenticationPrincipal User user, Board board, Comment comment, RedirectAttributes redirect){

        System.out.println("controller : " + board.getSeq());
        redirect.addAttribute("seq", board.getSeq());
        commentService.addComment(user.getUsername(), board.getSeq(), comment);


        return "redirect:getBoard?seq={seq}";
    }
}
