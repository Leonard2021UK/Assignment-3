package com.bootcamp2021.models;

/**
 * User class - stores user information
 */
public class User {

    private final String username;
    private final String password;
    private final String name;


    /**
     *
     * @param userInfo - User information
     */
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

}
