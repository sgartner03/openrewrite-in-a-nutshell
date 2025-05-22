package com.gepardec.courses.application;

import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.domain.ports.inbound.CreateMemberPort;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/members")
public class MembersResource {
    @Inject
    private CreateMemberPort createMemberPort;

    @POST
    public Member createMember(Member member) {
        createMemberPort.createMember(member);
        return member;
    }
}
