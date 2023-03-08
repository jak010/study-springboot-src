package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcampusmysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {

    private final MemberRepository memberRepository;
    final private MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    public Member create(RegisterMemberCommand command) {
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
        var savedMember = memberRepository.save(member);
        saveMemberNicknameHistory(savedMember);
        return savedMember;
    }

    public void changeNickName(Long memberId, String nickname) {
        var member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickName(nickname);
        memberRepository.save(member);

        saveMemberNicknameHistory(member);
    }

    private void saveMemberNicknameHistory(Member member) {
        var history = MemberNicknameHistory.builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .build();
        memberNicknameHistoryRepository.save(history);
    }


}
