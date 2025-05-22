package com.gepardec.courses.domain.ports.inbound;

import com.gepardec.courses.domain.model.Member;

public interface CreateMemberPort {
    void createMember(Member member);
}
