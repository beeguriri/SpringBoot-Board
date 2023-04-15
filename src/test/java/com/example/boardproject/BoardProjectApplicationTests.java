package com.example.boardproject;

import com.example.boardproject.domain.Board;
import com.example.boardproject.persistence.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardProjectApplicationTests {

    @Autowired
    BoardRepository boardRepo;

    @Test
    void contextLoads() {
    }

    @Test
    void insertTest() {
        Board board = new Board();

        board.setTitle("test3");
        boardRepo.save(board);
    }





}
