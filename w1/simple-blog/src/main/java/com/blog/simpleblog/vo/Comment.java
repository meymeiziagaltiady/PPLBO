package com.blog.simpleblog.vo;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "postId")
    private long postId;

    @Column(name = "user")
    private String user;

    @Column(name = "comment")
    private String comment;

    @Column(name = "regDate")
    private Date regDate;

    public Comment() {
    }

    public Comment(long postId, String user, String comment) {
        this.postId = postId;
        this.user = user;
        this.comment = comment;
        this.regDate = new Date();
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return this.postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getRegDate() {
        return this.regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

}