package org.globant.microserviceusers.controller;

import org.globant.microserviceusers.models.User;
import org.globant.microserviceusers.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User> user = userService.findById(id);

        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else {
            return ResponseEntity.internalServerError().body(
                    Collections.singletonMap("message", "Invalid id, try with a valid one")
            );
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody User user){
        userService.edit(user);
        Optional<User> newUser = userService.findById(user.getUserId());

        if (newUser.isPresent()) {
             return  ResponseEntity.ok(
                     Collections.singletonMap("User updated", user)
             );
        } else {
            return ResponseEntity.internalServerError()
                    .body(Collections.singletonMap("There was an error, try again", null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok(Collections.singletonMap("Message", "user deleted correctly"));
    }
}
