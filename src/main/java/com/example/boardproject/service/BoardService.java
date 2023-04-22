package com.example.boardproject.service;

import com.example.boardproject.domain.Board;
import com.example.boardproject.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepo;

//    public List<Board> getBoardList() {
//
//        return (List<Board>) boardRepo.findAll();
//
//    }

    public Page<Board> getBoardList(int page) {

        Pageable paging = PageRequest.of(page,15, Sort.by(Sort.Direction.DESC, "seq"));
        return boardRepo.findAll(paging);

    }

    public Board getBoard(Board board) {

        return boardRepo.findById(board.getSeq()).get();
    }

    public void addBoard(Board board) {

        boardRepo.save(board);

    }

    public void updateBoard(Board board) {

        Board updateBoard = boardRepo.findById(board.getSeq()).get();
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContent(board.getContent());

        boardRepo.save(updateBoard);

    }

    public void deleteBoard(Board board) {

        boardRepo.deleteById(board.getSeq());
    }

}
