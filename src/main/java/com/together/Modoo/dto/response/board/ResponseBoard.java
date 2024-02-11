package com.together.Modoo.dto.response.board;

import com.together.Modoo.dto.response.reply.ResponseReply;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseBoard {
    private Long id;
    private String title;
    private String content;
    private List<ResponseReply> replies;
    private String user;

    @Builder
    public ResponseBoard(Long id, String title, String content, List<ResponseReply> replies, String user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.replies = replies;
        this.user = user;
    }
}
