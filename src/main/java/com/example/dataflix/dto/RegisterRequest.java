package com.example.dataflix.dto;

public class RegisterRequest {
    private String usersName;
    private String usersSurname;
    private Integer age;
    private String email;
    private String password;

    public String getUsersName() { return usersName; }
    public void setUsersName(String usersName) { this.usersName = usersName; }
    public String getUsersSurname() { return usersSurname; }
    public void setUsersSurname(String usersSurname) { this.usersSurname = usersSurname; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
} 