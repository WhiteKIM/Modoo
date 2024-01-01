package com.together.Modoo.model;

import com.together.Modoo.global.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
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

    public void update(Reply reply) {
    }
}
