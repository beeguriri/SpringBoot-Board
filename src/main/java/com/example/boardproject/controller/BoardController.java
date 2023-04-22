package com.example.boardproject.controller;

import com.example.boardproject.domain.Board;
import com.example.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String getBoardList(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page) {

        Page<Board> boardList = boardService.getBoardList(page);

        model.addAttribute("boardList", boardList.getContent());
        model.addAttribute("totalPage", boardList.getTotalPages());

        return "boardList";

    }

    @GetMapping("/getBoard")
    public String getBoard(Model model, Board board){

        model.addAttribute("board", boardService.getBoard(board));

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
    public String insertBoardView() {

        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board){

        boardService.addBoard(board);

        return "redirect:boardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board){

        boardService.deleteBoard(board);

        return "redirect:boardList";
    }

}
