package com.together.Modoo.controller;

import com.together.Modoo.config.principal.PrincipalDetail;
import com.together.Modoo.dto.request.team.RequestTeam;
import com.together.Modoo.dto.response.team.ResponseTeam;
import com.together.Modoo.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/list")
    public ResponseEntity<List<ResponseTeam>> getUserAllTeam(@AuthenticationPrincipal PrincipalDetail user) {
        return ResponseEntity.ok(teamService.findTeamByUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTeam> getTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeam(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTeam(@RequestBody RequestTeam requestTeam) {
        teamService.save(requestTeam);
        return ResponseEntity.ok("팀 생성 성공");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTeam(@PathVariable Long id, @RequestBody RequestTeam requestTeam) {
        teamService.update(id, requestTeam);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
