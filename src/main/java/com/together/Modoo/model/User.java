package com.together.Modoo.model;

import com.together.Modoo.dto.request.RequestUser;
import com.together.Modoo.dto.response.ResponseUser;
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

    public User(RequestUser requestUser) {
        this.username = requestUser.getUsername();
        this.password = requestUser.getPassword();
        this.nickname = requestUser.getNickname();
        this.email = requestUser.getEmail();
    }

    public ResponseUser toDto() {
        return ResponseUser.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .members(members.stream().map(Member::toDto).toList())
                .boards(boards.stream().map(Board::toDto).toList())
                .replies(replies.stream().map(Reply::toDto).toList())
                .build();
    }

    public void update(User user) {
    }
}
