package org.globant.microservicecomments.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentId;

    @Size(min=2, max=250)
    @NotEmpty
    private String content;

    // User microservice FK reference
    @NotEmpty
    private Long authorId;

    // Post microservice FK reference
    @NotEmpty
    private Long postId;

    public Comment() {
    }

    public Comment(Long commentId, String content, Long authorId, Long postId) {
        CommentId = commentId;
        this.content = content;
        this.authorId = authorId;
        this.postId = postId;
    }

    public Long getCommentId() {
        return CommentId;
    }

    public void setCommentId(Long commentId) {
        CommentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getauthorId() {
        return authorId;
    }

    public void setauthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getpostId() {
        return postId;
    }

    public void setpostId(Long postId) {
        this.postId = postId;
    }
}
