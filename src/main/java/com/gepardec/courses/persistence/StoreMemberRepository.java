package com.gepardec.courses.persistence;

import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.domain.ports.outbound.StoreMemberPort;
import com.gepardec.courses.persistence.mapper.MemberMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StoreMemberRepository implements StoreMemberPort {

    @Inject
    EntityManager entityManager;

    @Override
    public void storeMember(Member member) {
        entityManager.persist(MemberMapper.map(member));
    }
}
