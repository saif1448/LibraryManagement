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

//        boolean isApplicationRunning = true;
//        boolean isLoggedIn = false;
//
//        while (isApplicationRunning) {
//            if (!isLoggedIn) {
//                //It is handling login
//                System.out.println("1. Log in \n" +
//                                    "2. Exit From Program");
//                int option = Integer.parseInt(sc.nextLine());
//                if(option == 1){
//                    isLoggedIn = userAuthenticationService.handleLogin();
//                }else{
//                    isApplicationRunning = false;
//                    System.out.println("Exiting from the application");
//                }
//
//            } else {
//                isLoggedIn = menuService.showMenu();
//            }
//        }


        List<Member> memberList = new ArrayList<>();

        Member member1 = new Member(1L, "Alice Johnson", 25, "123 Main St, Springfield");
        Member member2 = new Member(2L, "Ethan Hunt", 30, "456 Elm St, Shelbyville");
        Member member3 = new Member(3L, "Charlie Davis", 28, "789 Oak St, Capital City");
        Member member4 = new Member(4L, "Tiana Prince", 32, "101 Maple St, Gotham");
        Member member5 = new Member(5L, "Bob Smith", 29, "202 Pine St, Metropolis");

        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);
        memberList.add(member5);

//        Collections.sort(memberList, (m1, m2) -> m1.getAge().compareTo(m2.getAge()));
//        members.sort(Comparator.comparingInt(Member::getAge));

        System.out.println(memberList);


    }
}