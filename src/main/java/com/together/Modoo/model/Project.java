package com.together.Modoo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    private List<Skill> skills = new ArrayList<>();

    @OneToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    private Team team;

    public void update(Project project) {
    }
}
