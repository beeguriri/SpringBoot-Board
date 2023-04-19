package com.example.boardproject.service;

import com.example.boardproject.domain.Comment;
import com.example.boardproject.persistence.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepo;

    public List<Comment> getCommentList() {

        return (List<Comment>) commentRepo.findAll();

    }

    public void addComment(Comment comment) {

        commentRepo.save(comment);

    }

    public void updateComment(Comment comment) {

        Comment updateComment = commentRepo.findById(comment.getSeq()).get();
        updateComment.setContent(comment.getContent());

        commentRepo.save(updateComment);

    }

    public void deleteComment(Comment comment) {

        commentRepo.deleteById(comment.getSeq());
    }

}
