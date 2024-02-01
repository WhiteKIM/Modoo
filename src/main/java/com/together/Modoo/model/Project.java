package com.together.Modoo.model;

import com.together.Modoo.dto.request.project.RequestProject;
import com.together.Modoo.dto.response.project.ResponseProject;
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
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ElementCollection
    private List<String> skills = new ArrayList<>();

    @OneToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    private Team team;

    public Project(RequestProject requestProject) {
        this.title = requestProject.title();
        this.skills = requestProject.skills();
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public ResponseProject toDto() {
        return ResponseProject.builder()
                .id(id)
                .title(title)
                .skills(skills)
                .categories(categories.stream().map(Category::toDto).toList())
                .build();
    }

    public void update(RequestProject project) {
    }
}
