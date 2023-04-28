package com.example.boardproject.service;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.domain.Member;
import com.example.boardproject.persistence.BoardRepository;
import com.example.boardproject.persistence.CommentRepository;
import com.example.boardproject.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepo;

    @Autowired
    MemberRepository memberRepo;

    @Autowired
    BoardRepository boardRepo;

    public List<Comment> getCommentList() {

        return (List<Comment>) commentRepo.findAll();

    }

    public Comment getComment(Comment comment) {
        return commentRepo.findById(comment.getSeq()).get();
    }

    public void addComment(String userId, Long boardSeq, Comment comment) {

        System.out.println("service : " + boardSeq);

        Member member = memberRepo.findByMemberId(userId).get();
        Board getBoard = boardRepo.findById(boardSeq).get();
        Comment newcomment = new Comment();
        newcomment.setMember(member);
        newcomment.setBoard(getBoard);
        newcomment.setContent(comment.getContent());
        commentRepo.save(newcomment);

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
