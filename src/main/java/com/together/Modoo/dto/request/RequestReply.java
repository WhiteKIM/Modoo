package com.together.Modoo.dto.request;

import lombok.Data;

@Data
public class RequestReply {
    private String message;
    private Long boardId;
    private Long userId;
    private Long parentId;
}
