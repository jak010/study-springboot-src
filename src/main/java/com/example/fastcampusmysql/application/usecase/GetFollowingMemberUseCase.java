package com.example.fastcampusmysql.application.usecase;

import com.example.fastcampusmysql.domain.follow.entity.Follow;
import com.example.fastcampusmysql.domain.follow.repository.FollowRepository;
import com.example.fastcampusmysql.domain.follow.service.FollowReadService;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetFollowingMemberUseCase {

    final private MemberReadService memberReadService;
    final private FollowReadService followReadService;

    public List<MemberDto> execute(Long memberId) {
        /*
            fromMemberId = memberid -> Follow list
        * */

        var followings = followReadService.getFollowins(memberId);
        var followMemberIds = followings.stream().map(Follow::getToMemberId).toList();
        return memberReadService.getMembers(followMemberIds);

    }

}
