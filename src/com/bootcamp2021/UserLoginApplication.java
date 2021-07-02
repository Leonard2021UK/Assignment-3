package com.bootcamp2021;

import com.bootcamp2021.services.FileService;
import com.bootcamp2021.services.UserService;
import java.util.Scanner;

public class  UserLoginApplication {

    public static void main(String[] args) {

        // instantiate services
        FileService fileService = new FileService();
        UserService userService = new UserService();

        // state of the current user
        boolean userIsAuthenticated = false;

        // read the data from the file into an array
        fileService.readFile();

        // create users based on the data read from the file
        for (String userInfo:fileService.getDataArray()){
            userService.setUser(userInfo);
        }

        // It uses try-with-resources where the resource "Scanner" is automatically closed once finished (normally or abruptly),
        // hence no need for finally block. Any object is consider to be a resource if implements AutoCloseable interface.
        try (Scanner scanner = new Scanner(System.in)) {

            while (!userIsAuthenticated  && userService.hasMoreLoginAttempts() ){

                System.out.println("Please enter your username:");
                String username = scanner.nextLine();

                System.out.println("Please enter your password:");
                String password = scanner.nextLine();

                if(userIsAuthenticated = userService.authenticateUSer(username, password)){

                    String loggedInUser = userService.getLoggedInUser().getName();
                    System.out.println("Welcome " + loggedInUser);

                }else{
                    // prevents giving the chance to re try at the final attempt
                    if(userService.hasMoreLoginAttempts()) {
                        System.out.println("Invalid login, please try again.");
                    }else{
                        System.out.println("Too many failed login attempts, you are now locked out.");

                    }
                }
            }


        }catch (Exception e){
            System.out.println("Ooops, something went wrong!");
            System.out.println(e.getMessage());
        }

    }
}
