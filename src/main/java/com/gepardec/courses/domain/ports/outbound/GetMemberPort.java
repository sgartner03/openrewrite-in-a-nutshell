package com.gepardec.courses.domain.ports.outbound;

import com.gepardec.courses.domain.model.Member;

public interface GetMemberPort {
    Member getMember(int memberId);
}
