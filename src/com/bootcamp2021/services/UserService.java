package com.bootcamp2021.services;

import com.bootcamp2021.models.User;

import java.util.ArrayList;

public class UserService {

    ArrayList<User> users = new ArrayList<>();

    private int invalidLoginAttempts;

    public UserService() {
        this.invalidLoginAttempts = 0;
    }

    private User createUser(String data){
        String[] userDetails = data.split(",");
        return new User(userDetails);
    }

    public boolean hasAnotherAttempt() {
        return this.invalidLoginAttempts < 5;
    }

    public void setUser(String userData){
        users.add(this.createUser(userData));
    }

    public boolean authenticateUSer(String userName, String password){
        for (User user : users){
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                System.out.println("Welcome " + user.getName());
                return true;
            }
        }

        System.out.println("Invalid login, please try again.");
        this.invalidLoginAttempts++;

        return false;
    }

}
