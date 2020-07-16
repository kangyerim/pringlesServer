package com.pringles.web.member;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MemberRepositoryImpl extends QuerydslRepositorySupport {

    public MemberRepositoryImpl() {
        super(Member.class);
    }

}
