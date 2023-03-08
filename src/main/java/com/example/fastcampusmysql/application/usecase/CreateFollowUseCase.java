package com.example.fastcampusmysql.application.usecase;

import com.example.fastcampusmysql.domain.follow.service.FollowWriteService;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import com.example.fastcampusmysql.domain.member.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateFollowUseCase {

    final private MemberReadService memberReadService;
    final private FollowWriteService followWriteService;


    public void execute(Long fromMemberId, Long toMemberId) {
        /**
         *  1. 입력받은 MemberId로 회원 조회,
         *  2.
         * */
        var fromMember = memberReadService.getMember(fromMemberId);
        var toMember = memberReadService.getMember(toMemberId);

        followWriteService.create(fromMember, toMember);

    }

}
