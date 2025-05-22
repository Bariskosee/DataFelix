package com.example.dataflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "users_name")
    private String usersName;

    @Column(name = "users_surname")
    private String usersSurname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    // Getters and setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsersName() { return usersName; }
    public void setUsersName(String usersName) { this.usersName = usersName; }

    public String getUsersSurname() { return usersSurname; }
    public void setUsersSurname(String usersSurname) { this.usersSurname = usersSurname; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
} 