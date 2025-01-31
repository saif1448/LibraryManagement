package org.example.models;
import lombok.ToString;

import java.util.*;


public class Library {

    private List<Book> allBooks;
    private List<Member> allMembers;

    public Library(){
        allBooks = new ArrayList<>();
        allMembers = new ArrayList<>();
    }

    public void addBook(Book newBook){
        allBooks.add(newBook);
    }

    public void removeBook(Book book){
        allBooks.remove(book);
    }

    public void addMember(Member newMember){
        allMembers.add(newMember);
    }

    public void removeMember(Member member){
        allMembers.remove(member);
    }

    public void showAllBook(){
        int i = 1;
        for(var book : allBooks){
            System.out.println(i++ + "." + book);
        }
    }

    public void showAllMembers(){

        int i = 1;
        for(var member : allMembers){
            System.out.println(i++ + "." + member);
        }

    }


    public List<Book> getAllBooks() {
        return allBooks;
    }

    public List<Member> getAllMembers() {
        return allMembers;
    }

    @Override
    public String toString() {
        return "Library[" +
                "allBooks=" + allBooks +
                ", allMembers=" + allMembers +
                ']';
    }
}
