package marimo.harmonimo.service;

import marimo.harmonimo.domain.Board;
import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.Board.BoardDTO;
import marimo.harmonimo.dto.Board.BoardIdDTO;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.repository.BoardRepository;
import marimo.harmonimo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    @Autowired
    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }


    public BoardIdDTO createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        userRepository.findById(boardDTO.getUserId())
                        .ifPresent(user->board.setUser(user));
        board.setContent(boardDTO.getContent());
        board.setImg(boardDTO.getImg());

        Board savedBoard = boardRepository.save(board);
        Long boardId = savedBoard.getBoardId();
        BoardIdDTO boardIdDTO = new BoardIdDTO();
        boardIdDTO.setBoardId(boardId);
        return boardIdDTO;
    }

    public boolean deleteBoard(Long boardId) {
        if (boardRepository.existsById(boardId)) {
            boardRepository.deleteById(boardId);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateBoard(Long boardId, BoardDTO updatedBoardDTO) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);

        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setContent(updatedBoardDTO.getContent());
            board.setImg(updatedBoardDTO.getImg());

            Board savedBoard = boardRepository.save(board);
            return true;
        }else{
            return false;
        }
    }

    public List<BoardDTO> getBoards() { //entity객체는 service에서만
        List<Board> boards = boardRepository.findAll();
        List<BoardDTO> dtos = boards.stream()
                .map(BoardDTO::convertToDTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }
}
