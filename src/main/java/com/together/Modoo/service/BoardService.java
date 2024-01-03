package com.together.Modoo.service;

import com.together.Modoo.dto.request.RequestBoard;
import com.together.Modoo.dto.response.ResponseBoard;
import com.together.Modoo.model.Board;
import com.together.Modoo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<ResponseBoard> getAll() {
        return boardRepository.findAll().stream().map(Board::toDto).toList();
    }

    public void save(RequestBoard board) {
        boardRepository.save(new Board(board));
    }

    public ResponseBoard getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(RuntimeException::new);
        return board.toDto();
    }

    public void update(Long id, RequestBoard board) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        if(boardOptional.isEmpty())
            throw new RuntimeException();

        Board board1 = boardOptional.get();
        board1.update(board);
    }

    public void deleteBoard(Long id) {
        return;
    }
}
