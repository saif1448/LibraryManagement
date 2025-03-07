package org.example.service;

import org.example.Main;
import org.example.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UserAuthenticationService {

    private static Logger logger = LoggerFactory.getLogger(UserAuthenticationService.class);

    Scanner sc;
    UserService service;

    public UserAuthenticationService(Scanner sc, UserService service){
        this.sc = sc;
        this.service = service;
    }

    public boolean handleLogin(){

        System.out.println("Login to existing user");

        System.out.println("Enter User Name: \n");
        String userName = sc.nextLine();
        System.out.println("Enter Password: \n");
        String password = sc.nextLine();

        if(service.isValidUser(userName, password)){
            System.out.println("It is a valid user");
            return true;
        }else {
            System.out.println("Not a valid User!");
            System.out.println("Create a new user!");
            createNewUser();
            return false;
        }
    }

    private void createNewUser(){
        System.out.println("Ener userId: ");
        int userId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter userName: ");
        String userName = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();

        User newUser = new User(userId, userName, email, address, password);
        service.addUser(newUser);
        System.out.println("New user with user name " + userName + " has been created!");
    }
}
