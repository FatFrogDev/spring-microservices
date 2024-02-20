package org.globant.microserviceposts.controller;

import org.globant.microserviceposts.models.Post;
import org.globant.microserviceposts.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Post> post = postService.findById(id);
        HashMap<String, Post> response = new HashMap<>();

        if (post.isPresent()){
            response.put("Post found: ", post.get());
        }else {
            response.put("Post not found, try with a valid id", new Post());
        };
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Post post){
        HashMap<String, Post> response = new HashMap<>();
        postService.edit(post);
        Optional<Post> newPost = postService.findById(post.getPostId());

        if (newPost.isPresent()) {
            response.put("Post updated", post);
        } else response.put("There was an error, try again", null);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        postService.deleteById(id);
        return ResponseEntity.ok(Collections.singletonMap("Message","Error while deleting the post"));
    }
}
