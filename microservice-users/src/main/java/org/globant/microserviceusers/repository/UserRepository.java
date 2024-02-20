package org.globant.microserviceusers.repository;

import org.globant.microserviceusers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
