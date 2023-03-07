package com.example.fastcampusmysql.domain.service;

import com.example.fastcampusmysql.domain.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.entity.Member;
import com.example.fastcampusmysql.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriterService {

    private final MemberRepository memberRepository;

    public Member register(RegisterMemberCommand command) {
        /* 목표 - 회원정보 등록하기(이메일, 생년월일)
                - 닉네임은 10자를 넘길 수 없다.
            memberRegisterCommand
        *   memberRepository.save();
        * */

        var member = Member.builder()
                .nickname(command.nickname())
                .email(command.email())
                .birthday(command.birthday())
                .build();
        return memberRepository.save(member);

    }

}
