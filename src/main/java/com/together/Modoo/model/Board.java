package com.together.Modoo.model;

import com.together.Modoo.global.BaseTime;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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

    public void update(Board board) {
    }
}
