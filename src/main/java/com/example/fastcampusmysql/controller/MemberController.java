package com.example.fastcampusmysql.controller;


import com.example.fastcampusmysql.domain.dto.MemberDto;
import com.example.fastcampusmysql.domain.dto.MemberNicknameHistoryDto;
import com.example.fastcampusmysql.domain.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.service.MemberReadService;
import com.example.fastcampusmysql.domain.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    final private MemberWriteService memberWriteService;
    final private MemberReadService memberReaderService;

    @PostMapping("/members")
    public MemberDto register(@RequestBody RegisterMemberCommand command) {
        var member = memberWriteService.create(command);
        return memberReaderService.toDto(member);
    }

    @GetMapping("/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReaderService.getMember(id);
    }

    @PutMapping("/{id}/name")
    public MemberDto changeNickName(
            @PathVariable Long id,
            @RequestBody String nickname
    ) {
        memberWriteService.changeNickName(id, nickname);
        return memberReaderService.getMember(id);
    }

    @GetMapping("/{memberId}/nickname-histories")
    public List<MemberNicknameHistoryDto> getNickNameHistories(@PathVariable Long memberId) {
        return memberReaderService.getNicknameHistories(memberId);

    }
}
