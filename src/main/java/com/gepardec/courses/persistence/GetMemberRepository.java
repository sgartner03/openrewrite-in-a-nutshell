package com.gepardec.courses.persistence;

import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.domain.ports.outbound.GetMemberPort;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class GetMemberRepository implements GetMemberPort {

    @Inject
    EntityManager entityManager;

    @Override
    public Member getMember(int memberId) {
        return entityManager.find(Member.class, memberId);
    }
}
