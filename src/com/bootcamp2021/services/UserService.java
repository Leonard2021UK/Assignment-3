package com.bootcamp2021.services;

import com.bootcamp2021.models.User;

import java.util.ArrayList;

public class UserService {

    ArrayList<User> users = new ArrayList<>();

    private User createUser(String data){
        String[] userDetails = data.split(",");
        return new User(userDetails);
    }

    public void setUser(String userData){
        users.add(this.createUser(userData));
    }

    public void validateUSer(String userName, String password){
        for (User user : users){
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {

                System.out.println("Welcome " + user.getName());

            }else{
                System.out.println("Invalid login, please try again.");
            }
        }
    }

}
