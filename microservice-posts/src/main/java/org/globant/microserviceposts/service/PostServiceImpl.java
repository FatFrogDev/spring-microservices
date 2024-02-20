package org.globant.microserviceposts.service;

import org.globant.microserviceposts.models.Post;
import org.globant.microserviceposts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return List.copyOf(postRepository.findAll());
    }

    @Override
    public void edit(Post post) {
        try {
            postRepository.save(post);
        }catch (Exception e){
            System.out.println("There was an error while editing the post: " + e);
        }

    }
    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
