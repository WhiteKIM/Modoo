package com.together.Modoo.dto.response.reply;

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
    private String board;
    private List<ResponseReply> replies;
    private ResponseReply parent;
    private Integer level;
}
