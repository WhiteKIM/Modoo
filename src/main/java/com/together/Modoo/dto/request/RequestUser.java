package com.together.Modoo.dto.request;

import lombok.Data;

@Data
public class RequestUser {
    private String username;
    private String password;
    private String nickname;
    private String email;
}
