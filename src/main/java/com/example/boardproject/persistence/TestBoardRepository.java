package com.example.boardproject.persistence;

import com.example.boardproject.domain.TestBoard;
import org.springframework.data.repository.CrudRepository;

public interface TestBoardRepository extends CrudRepository<TestBoard, Long> {
}
