package com.example.fastcampusmysql.controller;

import com.example.fastcampusmysql.application.usecase.CreateFollowUseCase;
import com.example.fastcampusmysql.application.usecase.GetFollowingMemberUseCase;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {

    final private CreateFollowUseCase createFollowUseCase;
    final private GetFollowingMemberUseCase getFollowingMemberUseCase;

    @PostMapping("/{fromId}/{toId}")
    public void register(@PathVariable Long fromId, @PathVariable Long toId) {
        createFollowUseCase.execute(fromId, toId);
    }

    @GetMapping("/members/{fromId}/")
    public List<MemberDto> register(@PathVariable Long fromId) {
        return getFollowingMemberUseCase.execute(fromId);
    }
}
