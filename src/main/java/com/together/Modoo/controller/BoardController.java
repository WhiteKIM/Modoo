package com.together.Modoo.controller;

import com.together.Modoo.dto.request.RequestBoard;
import com.together.Modoo.dto.response.ResponseBoard;
import com.together.Modoo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<ResponseBoard>> getList() {
        return ResponseEntity.ok(boardService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBoard> getBoard(Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }

    @PostMapping("/write")
    public ResponseEntity<String> write(RequestBoard board) {
        boardService.save(board);
        return ResponseEntity.ok("작성 완료");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, RequestBoard updateBoard) {
        boardService.update(id, updateBoard);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
