package com.together.Modoo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.together.Modoo.dto.response.member.ResponseMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    public ResponseMember toDto() {
        return ResponseMember.builder()
                .id(id)
                .user(user.toDto())
                .team(team.getTitle())
                .build();
    }

    public void update(Member member) {
    }
}
