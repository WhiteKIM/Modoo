package com.together.Modoo.dto.request.user;
public record RequestJoinUser (
        String username,
        String password,
        String nickname,
        String email
) {}
