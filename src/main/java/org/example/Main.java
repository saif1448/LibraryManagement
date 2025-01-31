package org.example;

import org.example.enums.Genre;
import org.example.models.Book;
import org.example.models.Library;
import org.example.models.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    // User Creation
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

        Member member1 = new Member(1,"ABCD", 28, "XZAS");
        Member member2 = new Member(2,"TYPA", 26, "TWEQ");

        Book book1 = new Book(1,"YXT", 2, Genre.SCIFI);
        Book book2 = new Book(2, "UTA", 2, Genre.FICTION);

        Library library = new Library();

        library.addMember(member1);
        library.addMember(member2);

        library.addBook(book1);
        library.addBook(book2);


//        System.out.println(library);
        logger.info(String.valueOf(library.getAllBooks()));


    }
}