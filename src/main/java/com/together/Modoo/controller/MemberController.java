package com.together.Modoo.controller;

import com.together.Modoo.dto.request.RequestMember;
import com.together.Modoo.dto.response.ResponseMember;
import com.together.Modoo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{teamId}")
    public ResponseEntity<List<ResponseMember>> findTeamMember(@PathVariable Long teamId) {
        return ResponseEntity.ok(memberService.findAllByTeamId(teamId));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTeam(RequestMember requestMember) {
        memberService.save(requestMember);
        return ResponseEntity.ok("등록 완료");
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMember(Long id) {
        memberService.delete(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
