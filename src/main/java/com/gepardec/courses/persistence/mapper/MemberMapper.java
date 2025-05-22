package com.gepardec.courses.persistence.mapper;

import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.persistence.entity.MemberEntity;

public class MemberMapper {
    public static Member map(MemberEntity memberEntity) {
        return new com.gepardec.courses.domain.model.Member(
                memberEntity.getName(),
                memberEntity.getEmail()
        );
    }

    public static MemberEntity map(Member member) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(member.getName());
        memberEntity.setEmail(member.getEmail());
        return memberEntity;
    }
}
