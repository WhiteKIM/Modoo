package com.together.Modoo.model;

import com.together.Modoo.dto.request.board.RequestBoard;
import com.together.Modoo.dto.response.board.ResponseBoard;
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
public class Board extends BaseTime {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @OneToMany
    private List<Reply> replies = new ArrayList<>();
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Board(RequestBoard requestBoard) {
        this.title = requestBoard.title();
        this.content = requestBoard.content();
    }

    public ResponseBoard toDto() {
        return ResponseBoard.builder()
                .id(id)
                .content(content)
                .title(title)
                .user(user.getUsername())
                .replies(replies.stream().map(Reply::toDto).toList())
                .build();
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }

    public void update(RequestBoard board) {
    }
}
