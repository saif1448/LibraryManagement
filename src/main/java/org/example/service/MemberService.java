package org.example.service;

import lombok.Getter;
import org.example.models.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Getter
public class MemberService {

    Logger logger = LoggerFactory.getLogger(MemberService.class);

    private List<Member> memberList;

    public MemberService(){

        memberList = new ArrayList<>();

        Member member1 = new Member(1L, "Alice Johnson", 25, "123 Main St, Springfield");
        Member member2 = new Member(2L, "Bob Smith", 30, "456 Elm St, Shelbyville");
        Member member3 = new Member(3L, "Charlie Davis", 28, "789 Oak St, Capital City");
        Member member4 = new Member(4L, "Diana Prince", 32, "101 Maple St, Gotham");
        Member member5 = new Member(5L, "Ethan Hunt", 29, "202 Pine St, Metropolis");

        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);
        memberList.add(member5);

    }


    public void addMember(Member member) {
        memberList.add(member);
    }

    public void updateMember(int id, Member updatedMember){
        int index = id-1;
        memberList.set(index, updatedMember);
    }

    public void deleteMember(int id){
        int index = id - 1;
        Member member = findByMemberId(id);
//        memberList.remove(index);
        memberList.remove(member);

        logger.info("Member List {}", memberList);

    }

    public Member findByMemberId(int id){
        for(var member: memberList){
            if(member.getId() == id){
                return member;
            }
        }
        return null;
    }
}
