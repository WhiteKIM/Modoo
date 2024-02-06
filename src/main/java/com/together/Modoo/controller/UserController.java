package com.together.Modoo.controller;

import com.together.Modoo.dto.request.user.RequestJoinUser;
import com.together.Modoo.dto.request.user.RequestLoginUser;
import com.together.Modoo.dto.request.user.RequestUser;
import com.together.Modoo.dto.response.user.ResponseUser;
import com.together.Modoo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody RequestJoinUser requestUser) {
        userService.join(requestUser);
        return ResponseEntity.ok("회원가입 완료");
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody RequestLoginUser loginUser, HttpServletRequest request, HttpServletResponse response) {
        userService.login(loginUser, request, response);
        return ResponseEntity.ok("로그인 성공");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("회원탈퇴 완료");
    }
    
    @GetMapping("/test")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> AuthenticationTest() {
        return ResponseEntity.ok("권한 인증 성공");
    }
}
