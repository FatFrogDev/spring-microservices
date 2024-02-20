package org.globant.microserviceposts.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Array;
import java.util.ArrayList;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @NotEmpty
    private String content;

    // Made static to handle a single template image.
    private static String image;

    @NotNull
    private Long authorId;

   private Long[] comments;

   public Post(){}

    public Post(Long postId, String content, Long authorId, Long[] comments) {
        this.postId = postId;
        this.content = content;
        this.authorId = authorId;
        this.comments = comments;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static String getImage() {
        return image;
    }

    public static void setImage(String image) {
        Post.image = image;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long[] getComments() {
        return comments;
    }

    public void setComments(Long[] comments) {
        this.comments = comments;
    }
}
