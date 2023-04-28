package com.example.boardproject.persistence;

import com.example.boardproject.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board b set b.cnt = b.cnt + 1 where b.seq = :seq")
    int updateView(@Param("seq") Long seq);

    Page<Board> findByTitleContaining(String keyword, Pageable pageable);
}
