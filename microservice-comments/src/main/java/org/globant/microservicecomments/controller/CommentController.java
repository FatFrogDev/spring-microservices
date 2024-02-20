package org.globant.microservicecomments.controller;

import org.globant.microservicecomments.models.Comment;
import org.globant.microservicecomments.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional <Comment> comment = commentService.findById(id);
        HashMap<String, Comment> response = new HashMap<>();

        if (comment.isPresent()){
            response.put("Comment found: ", comment.get());
        }else response.put("Comment not found, try with a valid id", new Comment());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Comment comment){
        HashMap<String, Comment> response = new HashMap<>();
        commentService.edit(comment);
        Optional<Comment> newComment = commentService.findById(comment.getCommentId());

        if (newComment.isPresent()) {
            response.put("Comment updated", comment);
        } else response.put("There was an error, try again", null);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        commentService.deleteById(id);
        return ResponseEntity.ok(Collections.singletonMap("Message", "comment deleted correctly"));
    }
}
