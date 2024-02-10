package com.together.Modoo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.together.Modoo.dto.request.team.RequestTeam;
import com.together.Modoo.dto.response.team.ResponseTeam;
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
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Project> projects = new ArrayList<>();

    public Team(RequestTeam requestTeam) {
        this.title = requestTeam.title();
    }

    public ResponseTeam toDto() {
        return ResponseTeam.builder()
                .id(id)
                .title(title)
                .members(members.stream().map(Member::toDto).toList())
                .projects(projects.stream().map(Project::toDto).toList())
                .build();
    }

    public void update(RequestTeam team) {
    }
}
