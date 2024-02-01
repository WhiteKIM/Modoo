package com.together.Modoo.controller;

import com.together.Modoo.dto.request.project.RequestProject;
import com.together.Modoo.dto.response.project.ResponseProject;
import com.together.Modoo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<ResponseProject>> getAllTeamProject(@PathVariable Long teamId) {
        return ResponseEntity.ok(projectService.getAllTeamProject(teamId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProject> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProject(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProject(@RequestBody RequestProject requestProject) {
        projectService.save(requestProject);
        return ResponseEntity.ok("생성 완료");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProject(@PathVariable Long id, @RequestBody RequestProject requestProject) {
        projectService.update(id, requestProject);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
