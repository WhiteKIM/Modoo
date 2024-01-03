package com.together.Modoo.model;

import com.together.Modoo.dto.request.RequestBoard;
import com.together.Modoo.dto.response.ResponseBoard;
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
    @ManyToOne
    private User user;

    public Board(RequestBoard requestBoard) {
        this.title = requestBoard.getTitle();
        this.content = requestBoard.getContent();
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
