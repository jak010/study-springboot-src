package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.entity.Member;
import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MemberTest {
    @DisplayName("회원은 닉네임을 변경할 수 없다")
    @Test
    public void testChangeName() {
        var member = MemberFixtureFactory.create();
        var expects = "pnu";

        member.changeNickName(expects);

        Assertions.assertEquals(expects, member.getNickname());
    }

    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다")
    @Test
    public void testNickNameMaxLength() {
        var member = MemberFixtureFactory.create();
        var overMaxLengthName = "pnuabcedfggh";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> member.changeNickName(overMaxLengthName)
        );

    }
}
