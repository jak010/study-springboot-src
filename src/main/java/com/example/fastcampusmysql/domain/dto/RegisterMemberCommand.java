package com.example.fastcampusmysql.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * java 16부터 record를 사용할 수 있음
 * - Getter Setter 자동, property로 사용 가능
 */
public record RegisterMemberCommand(
        String email,
        String nickname,
        LocalDate birthday
) {}
