package com.together.Modoo.model;

import com.together.Modoo.dto.request.RequestTeam;
import com.together.Modoo.dto.response.ResponseTeam;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany
    private List<Member> members = new ArrayList<>();
    @OneToMany
    private List<Project> projects = new ArrayList<>();

    public Team(RequestTeam requestTeam) {
        this.title = requestTeam.getTitle();
    }

    public ResponseTeam toDto() {
        return ResponseTeam.builder()
                .id(id)
                .title(title)
                .members(members.stream().map(Member::toDto).toList())
                .projects(projects.stream().map(Project::toDto).toList())
                .build();
    }

    public void update(Team team) {
    }
}
