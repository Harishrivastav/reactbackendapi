package com.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
