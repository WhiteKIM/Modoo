package com.together.Modoo.dto.response.reply;

import com.together.Modoo.dto.response.board.ResponseBoard;
import com.together.Modoo.dto.response.user.ResponseUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReply {
    private Long id;
    private String message;
    private ResponseBoard board;
    private ResponseUser user;
    private List<ResponseReply> replies;
    private ResponseReply parent;
    private Integer level;
}
