package com.together.Modoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUser {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private List<ResponseMember> members;
    private List<ResponseBoard> boards;
    private List<ResponseReply> replies;
}