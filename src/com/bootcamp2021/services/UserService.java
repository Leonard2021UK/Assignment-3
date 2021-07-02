package com.bootcamp2021.services;

import com.bootcamp2021.models.User;

import java.util.ArrayList;

public class UserService {

    ArrayList<User> users = new ArrayList<>();

    // Stores logged in user
    User loggedInUser = null;

    private int remainingLoginAttempts;

    public UserService() {
        this.remainingLoginAttempts = 5;
    }

    /**
     *
     * @param data - User information in String from, read from a file
     * @return Returns a new user object created from the provided String.
     */
    private User createUser(String data){
        String[] userDetails = data.split(",");
        return new User(userDetails);
    }

    public boolean hasMoreLoginAttempts() {
        return this.remainingLoginAttempts > 0;
    }

    public void setUser(String userData){
        users.add(this.createUser(userData));
    }

    private void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * @param userName - user's username
     * @param password - user's password
     * @return boolean - the result of the authentication
     */
    public boolean authenticateUSer(String userName, String password){
        for (User user : users){
            if (user.getUsername().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
                // store logged in user
                setLoggedInUser(user);
                return true;
            }
        }

        // if the authentication is unsuccessful reduce the remaining attempt
        this.remainingLoginAttempts--;

        return false;
    }

}
