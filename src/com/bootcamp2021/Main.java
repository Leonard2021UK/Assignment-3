package com.bootcamp2021;

import com.bootcamp2021.models.User;
import com.bootcamp2021.services.FileService;
import com.bootcamp2021.services.UserService;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // instantiate services
        FileService fileService = new FileService();
        UserService userService = new UserService();

        // read the data from the file into an array
        fileService.readFile();

        // create users based on the data read from the file
        for (String userInfo:fileService.getDataArray()){
            userService.setUser(userInfo);
        }

        // It uses try-with-resources where the resource "Scanner" is automatically closed once finished (normally or abruptly),
        // hence no need for finally block.
        try (Scanner scanner = new Scanner(System.in)){

            System.out.println("Please enter your username:");
            String username = scanner.nextLine();

            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            userService.validateUSer(username,password);

        }catch (Exception e){
            System.out.println("Ooops, something went wrong!");
            System.out.println(e.getMessage());
        }

    }
}
