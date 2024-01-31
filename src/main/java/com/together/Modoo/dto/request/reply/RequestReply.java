package com.together.Modoo.dto.request.reply;

public record RequestReply(
        String message,
        Long boardId,
        Long userId,
        Long parentId
) {
}
