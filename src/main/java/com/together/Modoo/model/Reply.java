package com.together.Modoo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.together.Modoo.dto.request.reply.RequestReply;
import com.together.Modoo.dto.response.reply.ResponseReply;
import com.together.Modoo.global.BaseTime;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply extends BaseTime {
    @Id
    @GeneratedValue
    private Long id;
    private String message;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Setter
    private Board board;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Setter
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Reply parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reply> replyList = new ArrayList<>();

    private Integer level = 0;

    public Reply(RequestReply requestReply) {
        this.message = requestReply.message();
    }

    public ResponseReply toDto() {
        List<ResponseReply> replies = childReplyDto();
        return ResponseReply.builder()
                .id(id)
                .message(message)
                .board(board.getTitle())
                .level(level)
                .replies(replies)
                .build();
    }

    public void setParent(Reply reply) {
        this.parent = reply;
        this.level = reply.getLevel() + 1;
    }

    public void update(Reply reply) {
    }

    private List<ResponseReply> childReplyDto() {
        List<ResponseReply> replies = new ArrayList<>();
        if (!replyList.isEmpty()) {
            for (Reply reply : replyList) {
                ResponseReply dto = reply.toDto();
                replies.add(dto);
            }
        }

        return replies;
    }
}
