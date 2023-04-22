package com.example.boardproject.persistence;

import com.example.boardproject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface BoardRepository extends JpaRepository<Board, Long> {
}
