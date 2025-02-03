package org.example;

import org.example.enums.Genre;
import org.example.models.Book;
import org.example.models.Library;
import org.example.models.Member;
import org.example.models.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static Scanner sc = new Scanner(System.in);

    private static UserService service = new UserService();

    private static Library library = new Library();

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

        boolean isApplicationRunning = true;
        boolean isLoggedIn = false;

        while (isApplicationRunning){
            if(!isLoggedIn){
                System.out.println("Enter User Name: \n");
                String userName = sc.nextLine();
                System.out.println("Enter Password: \n");
                String password = sc.nextLine();

                if(service.isValidUser(userName, password)){
                    System.out.println("It is a valid user");
                    isLoggedIn = true;
                }
                else{
                    System.out.println("Not a valid user!!");
                    System.out.println("Create a new user!");

                    System.out.println("Ener userId: ");
                    int userId = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter userName: ");
                    userName = sc.nextLine();
                    System.out.println("Enter email: ");
                    String email = sc.nextLine();
                    System.out.println("Enter address: ");
                    String address = sc.nextLine();
                    System.out.println("Enter password: ");
                    password = sc.nextLine();

                    User newUser = new User(userId, userName, email, address, password);
                    service.addUser(newUser);
                }

            }else{
                System.out.println("Choose Management Option: (1-8)");
                System.out.println("1. Add a member \n"
                                + "2. Update a member \n"
                                + "3. Delete a member \n"
                                + "4. Add a book \n"
                                + "5. Remove a book \n"
                                + "6. Update a book \n"
                                + " 7. Show all members \n"
                                + "8. Show all books" );

                int option = Integer.parseInt(sc.nextLine());

                switch (option){
                    case 1:
                        System.out.println("Enter member id:");
                        int memberId = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter member name: ");
                        String memberName = sc.nextLine();
                        System.out.println("Enter age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter address: ");
                        String address = sc.nextLine();
                        Member member = new Member(memberId,memberName, age, address);
                        library.addMember(member);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    default:


                }

            }
        }


    }
}