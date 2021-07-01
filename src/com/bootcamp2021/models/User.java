package com.bootcamp2021.models;

public class User {

    private final String username;
    private final String password;
    private String name;



    public User(String[] userInfo) {
        this.username = userInfo[0];
        this.password = userInfo[1];
        this.name = userInfo[2];
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
