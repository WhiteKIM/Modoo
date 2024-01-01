package com.together.Modoo.service;

import com.together.Modoo.model.Project;
import com.together.Modoo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public void save(Project project) {
        projectRepository.save(project);
    }

    public Project getProject(Long id) {
        return projectRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Project project) {
        Optional<Project> optionalProject = projectRepository.findById(project.getId());
        if(optionalProject.isEmpty())
            throw new RuntimeException();

        Project project1 = optionalProject.get();
        project1.update(project);
    }

    public void delete(Long id) {
        return;
    }
}
