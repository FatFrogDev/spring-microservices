package org.globant.microservicecomments.repository;

import org.globant.microservicecomments.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
