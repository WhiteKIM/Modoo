package com.together.Modoo.service;

import com.together.Modoo.model.Board;
import com.together.Modoo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Board board) {
        Optional<Board> boardOptional = boardRepository.findById(board.getId());
        if(boardOptional.isEmpty())
            throw new RuntimeException();

        Board board1 = boardOptional.get();
        board1.update(board);
    }

    public void deleteBoard(Long id) {
        return;
    }
}
