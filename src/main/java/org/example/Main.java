package org.example;

import org.example.enums.Genre;
import org.example.models.Book;
import org.example.models.Library;
import org.example.models.Member;
import org.example.models.User;
import org.example.service.MenuService;
import org.example.service.UserAuthenticationService;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static Scanner sc = new Scanner(System.in);

    private static UserService service = new UserService();

    private static Library library = new Library();

    private static UserAuthenticationService userAuthenticationService = new UserAuthenticationService(sc, service);

    private static MenuService menuService = new MenuService(sc, library);

    // User Creation --- done
    // Member add, deletion, update
    // Book add, delete, update
    // Borrow ---> A member will borrow a book
    // number of books needs to be changed
    // Return ---> A member will return a book
    // Filter ---> Book
    //        --- > Member
    // Sorting
    // Create a menu to handle all these things

    public static void main(String[] args) {
//
        boolean isApplicationRunning = true;
        boolean isLoggedIn = false;

        while (isApplicationRunning) {
            if (!isLoggedIn) {
                //It is handling login
                isLoggedIn = userAuthenticationService.handleLogin();
            } else {
                menuService.showMenu();
            }
        }





    }
}