package org.example.service;

import org.example.enums.Genre;
import org.example.models.Book;
import org.example.models.Library;
import org.example.models.Member;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuService {

    private Scanner sc;

//    private static Library library = new Library();

    private Library library;

//    private MemberService memberService = new MemberService();

    public MenuService(Scanner sc, Library library){
        this.sc = sc;
        this.library = library;
    }

    public boolean showMenu(){
        System.out.println("Choose Management Option: (1-8)");
        System.out.println("1. Add a member \n"
                + "2. Update a member \n"
                + "3. Delete a member \n"
                + "4. Add a book \n"
                + "5. Remove a book \n"
                + "6. Update a book \n"
                + "7. Show all members \n"
                + "8. Show all books \n"
                + "9. Sort Members \n"
                + "10. Sort Books \n"
                + "11. Log Out");

        int option = Integer.parseInt(sc.nextLine());

        switch (option){
            case 1:
                handleAddMember();
                break;
            case 2:
                handleUpdateMember();
                break;
            case 3:
                handleDeleteMember();
                break;
            case 4:
                handleAddBook();
                break;
            case 5:
                handleDeleteBook();
                break;
            case 6:
                handleUpdateBook();
                break;
            case 7:
                handleShowMember();
                break;
            case 8:
                handleShowBook();
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                return false;
            default:
                System.out.println("Wrong input was chosen");

        }

        return true;

    }


    private void handleAddMember(){
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
//        memberService.addMember(member);
    }

    private void handleUpdateMember(){

        handleShowMember();
        System.out.println("Choose Which Member Details to Update (member id): ");
        int memberId = Integer.parseInt(sc.nextLine());

//        Member memberToBeUpdated = memberService.findByMemberId(memberId);
        Member memberToBeUpdated = library.findByMemberId(memberId);

        if(memberToBeUpdated != null){
            System.out.println("Which Data to be Updated: \n"
                                +"1. Name \n"
                                +"2. Address");

            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    System.out.println("Update Name: ");
                    String updatedName = sc.nextLine();
                    memberToBeUpdated.setName(updatedName);
                    break;
                case 2:
                    System.out.println("Update Address: ");
                    String updatedAddress = sc.nextLine();
                    memberToBeUpdated.setAddress(updatedAddress);
            }

//            memberService.updateMember(memberId, memberToBeUpdated);
            library.updateMember(memberId, memberToBeUpdated);

        }{
            System.out.println("Member not found with the described Id");
        }


    }

    private void handleShowMember(){
//        int i = 1;
//        for(var member : library.getAllMembers()){
//            System.out.println(i++ + ". " + member.getName() + ", id: " + member.getId());
//        }
        library.showAllMembers();
    }

    private void handleDeleteMember(){
        System.out.println("Choose which member data to be deleted: ");
        handleShowMember();
        int memberId = Integer.parseInt(sc.nextLine());
//        memberService.deleteMember(memberId);
        library.removeMemberById(memberId);
    }


    private void handleAddBook() {
        System.out.println("Enter book id:");
        long bookId = Long.parseLong(sc.nextLine());
        System.out.println("Enter author name: ");
        String author = sc.nextLine();
        System.out.println("Enter edition: ");
        int edition = Integer.parseInt(sc.nextLine());
        System.out.println("Enter genre (ACTION, FICTION, SCIFI, NOVEL, ROMANCE, FANTASY, MYSTERY): ");
        String genreInput = sc.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreInput);

        Book book = new Book(bookId, author, edition, genre);
        library.addBook(book);
    }

    private void handleDeleteBook() {
        System.out.println("Choose which book data to be deleted: ");
        handleShowBook(); // Assuming this method displays the list of books
        int bookId = Integer.parseInt(sc.nextLine());
//    bookService.deleteBook(bookId);
        library.removeBookById(bookId);
    }

    private void handleShowBook(){
        library.showAllBook();
    }

    private void handleUpdateBook() {
        handleShowBook();
        System.out.println("Choose Which Book Details to Update (book id): ");
        int bookId = Integer.parseInt(sc.nextLine());

        Book bookToBeUpdated = library.findByBookId(bookId);

        if (bookToBeUpdated != null) {
            System.out.println("Which Data to be Updated: \n"
                    + "1. Author \n"
                    + "2. Edition \n"
                    + "3. Genre");

            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Update Author: ");
                    String updatedAuthor = sc.nextLine();
                    bookToBeUpdated.setAuthor(updatedAuthor);
                    break;
                case 2:
                    System.out.println("Update Edition: ");
                    int updatedEdition = Integer.parseInt(sc.nextLine());
                    bookToBeUpdated.setEdition(updatedEdition);
                    break;
                case 3:
                    System.out.println("Update Genre (ACTION, FICTION, SCIFI, NOVEL, ROMANCE, FANTASY, MYSTERY): ");
                    String updatedGenre = sc.nextLine().toUpperCase();
                    bookToBeUpdated.setGenre(Genre.valueOf(updatedGenre));
                    break;
                default:
                    System.out.println("Invalid option!");
                    return;
            }

            library.updateBook(bookId, bookToBeUpdated);

        } else {
            System.out.println("Book not found with the described Id");
        }
    }


}
