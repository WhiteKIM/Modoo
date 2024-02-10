package com.together.Modoo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.together.Modoo.dto.request.user.RequestJoinUser;
import com.together.Modoo.dto.request.user.RequestUser;
import com.together.Modoo.dto.response.user.ResponseUser;
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
@Table(name = "users")
public class User extends BaseTime {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @Setter
    private String password;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Reply> replies = new ArrayList<>();
    private String role = "ROLE_USER";


    // 나중에 지우셈
    public User(RequestUser requestUser) {
        this.username = requestUser.username();
        this.password = requestUser.password();
        this.nickname = requestUser.nickname();
        this.email = requestUser.email();
    }

    public User(RequestJoinUser requestUser) {
        this.username = requestUser.username();
        this.password = requestUser.password();
        this.nickname = requestUser.nickname();
        this.email = requestUser.email();
    }

    public ResponseUser toDto() {
        return ResponseUser.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .boards(boards.stream().map(Board::toDto).toList())
                .replies(replies.stream().map(Reply::toDto).toList())
                .build();
    }

    public void update(User user) {
    }
}

