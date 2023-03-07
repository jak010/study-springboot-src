package com.example.fastcampusmysql.domain.service;

import com.example.fastcampusmysql.domain.dto.MemberDto;
import com.example.fastcampusmysql.domain.dto.MemberNicknameHistoryDto;
import com.example.fastcampusmysql.domain.entity.Member;
import com.example.fastcampusmysql.domain.entity.MemberNicknameHistory;
import com.example.fastcampusmysql.domain.repository.MemberNicknameHistoryRepository;
import com.example.fastcampusmysql.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class MemberReadService {

    final private MemberRepository memberRepository;
    final private MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    public MemberDto getMember(Long id) {
        var member = memberRepository.findById(id).orElseThrow();
        return toDto(member);
    }

    public List<MemberNicknameHistoryDto> getNicknameHistories(Long memberId) {
        var histories = memberNicknameHistoryRepository.findAllByMemberId(memberId);
        return histories.stream()
                .map(this::toDto)
                .toList();
    }

    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getBirthday()
        );
    }

    public MemberNicknameHistoryDto toDto(MemberNicknameHistory history) {
        return new MemberNicknameHistoryDto(
                history.getId(),
                history.getMemberId(),
                history.getNickname(),
                history.getCreatedAt()
        );
    }

}
