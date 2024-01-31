package com.together.Modoo.controller;

import com.together.Modoo.dto.request.reply.RequestReply;
import com.together.Modoo.dto.response.reply.ResponseReply;
import com.together.Modoo.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ResponseReply>> getUserReplies(@PathVariable Long id) {
        return ResponseEntity.ok(replyService.getUserReplies(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseReply> getReply(@PathVariable Long id) {
        return ResponseEntity.ok(replyService.getReply(id));
    }

    @PostMapping("/write")
    public ResponseEntity<String> writeReply(RequestReply requestReply) {
        replyService.save(requestReply);
        return ResponseEntity.ok("작성 완료");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReply(@PathVariable Long id) {
        replyService.delete(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
