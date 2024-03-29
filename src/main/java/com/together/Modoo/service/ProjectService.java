package com.together.Modoo.service;

import com.together.Modoo.dto.request.project.RequestProject;
import com.together.Modoo.dto.response.project.ResponseProject;
import com.together.Modoo.model.Category;
import com.together.Modoo.model.Project;
import com.together.Modoo.repository.CategoryRepository;
import com.together.Modoo.repository.ProjectRepository;
import com.together.Modoo.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;
    private final CategoryRepository categoryRepository;

    public void save(RequestProject project) {
        Project createProject = new Project(project);
        createProject.setTeam(teamRepository.findById(project.teamId()).orElseThrow());
        List<Category> categories = new ArrayList<>();
        for (Long categoryId : project.categoriesId()) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
            optionalCategory.ifPresent(categories::add);
        }
        createProject.setCategories(categories);
        projectRepository.save(createProject);
    }

    public ResponseProject getProject(Long id) {
        return projectRepository.findById(id).orElseThrow(RuntimeException::new).toDto();
    }

    public void update(Long id, RequestProject project) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isEmpty())
            throw new RuntimeException();

        Project project1 = optionalProject.get();
        project1.update(project);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    public List<ResponseProject> getAllTeamProject(Long teamId) {
        List<Project> projectList = projectRepository.findAllByTeam(teamRepository.findById(teamId).orElseThrow());
        return projectList.stream().map(Project::toDto).toList();
    }
}
