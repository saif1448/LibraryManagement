package org.example.service;

import org.example.models.Member;

import java.util.*;

public class MemberService {
    private List<Member> memberList;

    public MemberService(){
        memberList = new ArrayList<>();
    }

    public void addMember(Member member) {
        memberList.add(member);
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
