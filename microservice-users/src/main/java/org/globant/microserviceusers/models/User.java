package org.globant.microserviceusers.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 3, max=8)
    private String pin;

    public User() {
    }

    public User(Long userId, String name, String email, String pin) {
        UserId = userId;
        this.name = name;
        this.email = email;
        this.pin = pin;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
