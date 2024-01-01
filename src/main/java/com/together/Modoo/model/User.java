package com.together.Modoo.model;

import com.together.Modoo.global.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseTime {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Member> members = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Reply> replies = new ArrayList<>();

    public void update(User user) {
    }
}

