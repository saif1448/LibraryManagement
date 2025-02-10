package org.example.models;
import lombok.ToString;
import org.example.service.MemberService;

import java.util.*;


public class Library {

    private MemberService memberService = new MemberService();

    private List<Book> allBooks;
    private List<Member> allMembers;

    public Library(){
        allBooks = new ArrayList<>();
//        allMembers = new ArrayList<>();
        allMembers = memberService.getMemberList();
    }

    public void addBook(Book newBook){

        allBooks.add(newBook);
    }

    public void removeBook(Book book){
        allBooks.remove(book);
    }

    public void addMember(Member newMember){
        memberService.addMember(newMember);
        allMembers = memberService.getMemberList();
    }

    public void removeMember(Member member){
        allMembers.remove(member);
    }

    public void removeMemberById(int id){
//        int index = id-1;
        memberService.deleteMember(id);
//        allMembers.remove(index);
        allMembers = memberService.getMemberList();
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

    public Member findByMemberId(int id){
        return memberService.findByMemberId(id);
    }

    public void updateMember(int id, Member updatedMember){
        memberService.updateMember(id, updatedMember);
        allMembers = memberService.getMemberList();
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
