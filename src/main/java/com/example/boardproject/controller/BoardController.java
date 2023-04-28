package com.example.boardproject.controller;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.domain.Member;
import com.example.boardproject.persistence.MemberRepository;
import com.example.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    MemberRepository memberRepo;

//    @GetMapping("/boardList")
//    public String getBoardList(Model model) {
//
//        List<Board> boardList = boardService.getBoardList();
//        model.addAttribute("boardList", boardList);
//
//        return "boardList";
//
//    }

    @GetMapping("/boardList")
    public String getBoardList(@AuthenticationPrincipal User user, Model model,
                               @RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                String keyword) {

        Page<Board> boardList;

        if(keyword==null)
            boardList = boardService.getBoardList(page);
        else
            boardList = boardService.findByTitle(keyword, page);

        model.addAttribute("boardList", boardList.getContent());
        model.addAttribute("totalPage", boardList.getTotalPages());

        Member member = memberRepo.findByMemberId(user.getUsername()).get();
        model.addAttribute("member", member);
        model.addAttribute("loginId", member.getNickname());
        model.addAttribute("loginRoles", user.getAuthorities());

        return "boardList";

    }

    @GetMapping("/getBoard")
    public String getBoard(@AuthenticationPrincipal User user, Model model, Board board){

        Board getBoard = boardService.getBoard(board);

        boardService.updateVeiw(getBoard.getSeq());

        model.addAttribute("board", getBoard);

        model.addAttribute("memberID", user.getUsername());
        model.addAttribute("memberRoles", user.getAuthorities());

        List<Comment> commentList = getBoard.getCommentList();
        if(commentList != null)
            model.addAttribute("commentList", commentList);

        return "getBoard";
    }

    @GetMapping("/updateBoard")
    public String updateBoardView(Model model, Board board) {

        model.addAttribute("updateBoard", boardService.getBoard(board));
        return "updateBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board){

        boardService.updateBoard(board);

        return "redirect:boardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView(@AuthenticationPrincipal User user, Model model) {

        Member member = memberRepo.findByMemberId(user.getUsername()).get();
        model.addAttribute("member", member);

        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@AuthenticationPrincipal User user, Board board){

        boardService.addBoard(user.getUsername(), board);

        return "redirect:boardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board){

        boardService.deleteBoard(board);

        return "redirect:boardList";
    }

}
