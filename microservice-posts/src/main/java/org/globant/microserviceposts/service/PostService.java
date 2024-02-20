package org.globant.microserviceposts.service;

import org.globant.microserviceposts.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void save(Post post);
    Optional<Post> findById(Long id);
    List<Post> findAll();
    void edit (Post post);
    void deleteById (Long id);
}
