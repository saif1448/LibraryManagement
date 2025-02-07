package org.example.service;

import org.example.models.Library;
import org.example.models.Member;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuService {

    private Scanner sc;

//    private static Library library = new Library();

    private Library library;

    private MemberService memberService = new MemberService();

    public MenuService(Scanner sc, Library library){
        this.sc = sc;
        this.library = library;
    }

    public void showMenu(){
        System.out.println("Choose Management Option: (1-8)");
        System.out.println("1. Add a member \n"
                + "2. Update a member \n"
                + "3. Delete a member \n"
                + "4. Add a book \n"
                + "5. Remove a book \n"
                + "6. Update a book \n"
                + "7. Show all members \n"
                + "8. Show all books \n"
                + "9. Exit");

        int option = Integer.parseInt(sc.nextLine());

        switch (option){
            case 1:
                handleAddMember();
                break;
            case 2:
                handleUpdateMember();
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
                handleShowMember();
                break;
            case 8:
                break;
            default:

        }

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
        memberService.addMember(member);
    }

    private void handleUpdateMember(){

        handleShowMember();
        System.out.println("Choose Which Member Details to Update (member id): ");
        int memberId = Integer.parseInt(sc.nextLine());

        Member memberToBeUpdated = memberService.findByMemberId(memberId);

        if(memberToBeUpdated != null){
            System.out.println("Which Data to be Updated: \n"
                                +"1. Name \n"
                                +"2. Address");

        }{
            System.out.println("Member not found with the described Id");
        }


    }

    private void handleShowMember(){
        int i = 1;
        for(var member : library.getAllMembers()){
            System.out.println(i++ + ". " + member.getName() + ", id: " + member.getId());
        }
    }

}
