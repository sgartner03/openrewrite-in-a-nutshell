package com.gepardec.courses.domain.services;

import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.domain.ports.inbound.CreateMemberPort;
import com.gepardec.courses.domain.ports.outbound.StoreMemberPort;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateMemberService implements CreateMemberPort {

    @Inject
    StoreMemberPort storeMemberPort;

    @Override
    public void createMember(Member member) {
        storeMemberPort.storeMember(member);
    }
}
