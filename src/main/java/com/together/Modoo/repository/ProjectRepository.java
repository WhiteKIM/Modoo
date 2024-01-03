package com.together.Modoo.repository;

import com.together.Modoo.model.Project;
import com.together.Modoo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByTeam(Team team);
}
