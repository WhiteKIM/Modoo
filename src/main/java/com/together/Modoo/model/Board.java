package com.together.Modoo.model;

import com.together.Modoo.dto.request.board.RequestBoard;
import com.together.Modoo.dto.response.board.ResponseBoard;
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
public class Board extends BaseTime {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @OneToMany
    private List<Reply> replies = new ArrayList<>();
    @ManyToOne
    private User user;

    public Board(RequestBoard requestBoard) {
        this.title = requestBoard.title();
        this.content = requestBoard.content();
    }

    public ResponseBoard toDto() {
        ResponseBoard responseBoard = ResponseBoard.builder()
                .id(id)
                .content(content)
                .title(title)
                .build();

        return responseBoard;
    }

    public void update(RequestBoard board) {
    }
}
