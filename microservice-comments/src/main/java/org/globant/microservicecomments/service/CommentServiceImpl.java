package org.globant.microservicecomments.service;

import org.globant.microservicecomments.models.Comment;
import org.globant.microservicecomments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;


    @Override
    public void save(Comment coment) {
        commentRepository.save(coment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return List.copyOf(commentRepository.findAll());
    }

    @Override
    public void edit(Comment comment) {
        try {
            commentRepository.save(comment);
        } catch (Exception e){
            System.out.println("There was an error while trying to update the comment: " + e);
        }

    }
    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
