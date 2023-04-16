package com.example.boardproject.persistence;

import com.example.boardproject.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
