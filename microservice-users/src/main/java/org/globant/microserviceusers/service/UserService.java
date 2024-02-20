package org.globant.microserviceusers.service;

import org.globant.microserviceusers.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void edit (User user);
    void deleteById (Long id);
}
