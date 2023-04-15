package com.example.boardproject.persistence;

import com.example.boardproject.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
