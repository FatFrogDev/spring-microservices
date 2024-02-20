package org.globant.microserviceusers.service;

import org.globant.microserviceusers.models.User;
import org.globant.microserviceusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(userRepository.findAll());
    }

    @Override
    public void edit(User user) {
        try {
            userRepository.save(user);
        }catch (Exception e ){
            System.out.println("There was an error while updating the user: " + e);
        }
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
