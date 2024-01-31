package com.together.Modoo.dto.response.user;

import com.together.Modoo.dto.response.board.ResponseBoard;
import com.together.Modoo.dto.response.member.ResponseMember;
import com.together.Modoo.dto.response.reply.ResponseReply;
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