package com.together.Modoo.dto.request.user;

public record RequestUser(
        String username,
        String password,
        String nickname,
        String email
) {
}
