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
        memberList.remove(index);

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
