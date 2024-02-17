package com.blog.simpleblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.simpleblog.repository.CommentJpaRepository;
import com.blog.simpleblog.vo.Comment;

@Service
public class CommentService {

    @Autowired
    CommentJpaRepository commentJpaRepository;

    public List<Comment> getCommentList(Long postId) {
        List<Comment> commentList = commentJpaRepository.findAllByPostIdOrderByRegDateDesc(postId);
        return commentList;
    }

    public Comment getComment(Long id) {
        Comment comment = commentJpaRepository.findOneById(id);

        return comment;
    }

    public List<Comment> searchCommentByPostIdAndComment(Long postId, String query){
        List<Comment> comments = commentJpaRepository.findByPostIdAndCommentContainingOrderByRegDateDesc(postId ,query);
    
        return comments;
    }

    public Boolean saveComment(Comment comment) {
        Comment result = commentJpaRepository.save(comment);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean deleteComment(Long id){
        Comment result = commentJpaRepository.findOneById(id);

        if (result == null) {
            return false;
        }

        commentJpaRepository.deleteById(id);
        return true;
    }

 }
