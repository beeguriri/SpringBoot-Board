package com.example.boardproject.controller;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping ("/deleteComment")
    public String deleteComment(@AuthenticationPrincipal User user, Comment comment, RedirectAttributes redirect){

//        System.out.println(comment.toString());
        Comment delComment = commentService.getComment(comment);
//        System.out.println(delComment.toString());
        redirect.addAttribute("seq", delComment.getBoard().getSeq());
//        System.out.println("board 확인" + delComment.getBoard().getSeq());
//        System.out.println("commnet 확인" + delComment.getSeq() + delComment.getContent());
        commentService.deleteComment(delComment);

        return "redirect:getBoard?seq={seq}";
    }

    @GetMapping("/updateComment")
    public String updateCommentView(Model model, Comment comment){

        model.addAttribute("updateComment", commentService.getComment(comment));

        return "updateComment";
    }
    @PostMapping("/updateComment")
    public String updateCommentComment(@AuthenticationPrincipal User user, Board board, Comment comment, RedirectAttributes redirect){

        Comment upComment = commentService.getComment(comment);
        redirect.addAttribute("seq", upComment.getBoard().getSeq());

        commentService.updateComment(comment);

        return "redirect:getBoard?seq={seq}";
    }

}
