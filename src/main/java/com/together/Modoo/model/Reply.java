package com.together.Modoo.model;

import com.together.Modoo.dto.request.RequestReply;
import com.together.Modoo.dto.response.ResponseReply;
import com.together.Modoo.global.BaseTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private Board board;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "parent")
    private List<Reply> replyList = new ArrayList<>();
    @ManyToOne
    private Reply parent = this;
    private Integer level = 0;

    public Reply(RequestReply requestReply) {
        this.message = requestReply.getMessage();
    }

    public ResponseReply toDto() {
        return ResponseReply.builder()
                .id(id)
                .message(message)
                .board(board.toDto())
                .user(user.toDto())
                .level(level)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setParent(Reply reply) {
        this.parent = reply;
    }

    public void update(Reply reply) {
    }
}
