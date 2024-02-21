package com.together.Modoo.service;

import com.together.Modoo.dto.request.board.RequestBoard;
import com.together.Modoo.dto.response.board.ResponseBoard;
import com.together.Modoo.exception.NotExistBoard;
import com.together.Modoo.exception.NotExistUser;
import com.together.Modoo.model.Board;
import com.together.Modoo.model.User;
import com.together.Modoo.repository.BoardRepository;
import com.together.Modoo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<ResponseBoard> getAll() {
        return boardRepository.findAll().stream().map(Board::toDto).toList();
    }

    public void save(RequestBoard board) {
        User user = userRepository.findById(board.userId()).orElseThrow(NotExistUser::new);
        Board saveBoard = boardRepository.save(new Board(board));
        saveBoard.setUser(user);
    }

    public ResponseBoard getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(RuntimeException::new);
        return board.toDto();
    }

    public void update(Long id, RequestBoard board) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        if (boardOptional.isEmpty())
            throw new RuntimeException();

        Board board1 = boardOptional.get();
        board1.update(board);
    }

    public void deleteBoard(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);

        if (optionalBoard.isEmpty())
            throw new NotExistBoard();

        Board board = optionalBoard.get();
        board.setDeleteTime(ZonedDateTime.now());
    }
}
