package com.together.Modoo.controller;

import com.together.Modoo.dto.request.RequestUser;
import com.together.Modoo.dto.response.ResponseUser;
import com.together.Modoo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id]")
    public ResponseEntity<ResponseUser> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(RequestUser requestUser) {
        userService.save(requestUser);
        return ResponseEntity.ok("회원가입 완료");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("회원탈퇴 완료");
    }
}
