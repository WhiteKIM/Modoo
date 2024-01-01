package com.together.Modoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @OneToMany
    private List<Member> members = new ArrayList<>();
    @OneToMany
    private List<Project> projects = new ArrayList<>();

    public void update(Team team) {
    }
}
