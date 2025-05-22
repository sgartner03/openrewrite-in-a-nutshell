package com.gepardec.courses.domain.ports.outbound;

import com.gepardec.courses.domain.model.Member;

public interface StoreMemberPort {
    void storeMember(Member user);
}
