package com.example.fastcampusmysql.controller;


import com.example.fastcampusmysql.domain.dto.MemberDto;
import com.example.fastcampusmysql.domain.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.service.MemberReaderService;
import com.example.fastcampusmysql.domain.service.MemberWriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    final private MemberWriterService memberWriteService;
    final private MemberReaderService memberReaderService;

    @PostMapping("/members")
    public MemberDto register(@RequestBody RegisterMemberCommand command) {
        var member = memberWriteService.register(command);
        return memberReaderService.toDto(member);
    }

    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReaderService.getMember(id);
    }

}
