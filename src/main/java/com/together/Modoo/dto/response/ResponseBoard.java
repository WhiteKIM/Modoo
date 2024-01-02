package com.together.Modoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoard {
    private Long id;
    private String title;
    private String content;
    private List<ResponseReply> replies;
    private ResponseUser user;

    @Builder
    public ResponseBoard(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
