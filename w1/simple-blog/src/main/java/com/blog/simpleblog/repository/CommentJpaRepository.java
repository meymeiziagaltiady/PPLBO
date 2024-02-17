package com.blog.simpleblog.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.simpleblog.vo.Comment;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comment, Serializable> {
    Comment findOneById(Long id);
    List<Comment> findAllByPostIdOrderByRegDateDesc(Long postId);
    List<Comment> findByPostIdAndCommentContainingOrderByRegDateDesc(Long postId, String query);
}