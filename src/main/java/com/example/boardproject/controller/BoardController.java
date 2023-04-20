package com.example.boardproject.controller;

import com.example.boardproject.domain.Board;
import com.example.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/boardList")
    public String getBoardList(Model model) {

        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        return "boardList";

    }

    @GetMapping("/getBoard")
    public String getBoard(Model model, Board board){

        model.addAttribute("board", boardService.getBoard(board));

        return "getBoard";
    }

}
