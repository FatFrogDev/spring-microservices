package org.globant.microservicecomments.service;

import org.globant.microservicecomments.models.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CommentService {

    void save(Comment coment);
    Optional<Comment> findById(Long id);
    List<Comment> findAll();
    void edit (Comment comment);
    void deleteById (Long id);

}
