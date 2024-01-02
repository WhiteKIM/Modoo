package com.together.Modoo.model;

import com.together.Modoo.dto.response.ResponseMember;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;

    @ManyToOne
    private Team team;

    public ResponseMember toDto() {
        return ResponseMember.builder()
                .id(id)
                .user(user.toDto())
                .team(team.toDto())
                .build();
    }

    public void update(Member member) {
    }
}
