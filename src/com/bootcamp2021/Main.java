package com.bootcamp2021;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        // Store file path
        File file = new File("data/data.txt");

        // It uses try-with-resources where the resource "BufferedReader" is automatically closed once finished (normally or abruptly),
        // hence no need for finally block.
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String userData;
            while ((userData = br.readLine()) != null)
                System.out.println(userData);
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            System.out.println(e.getMessage());
        }
    }
}
