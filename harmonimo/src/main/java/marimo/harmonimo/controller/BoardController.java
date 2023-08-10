package marimo.harmonimo.controller;

import marimo.harmonimo.domain.Board;
import marimo.harmonimo.dto.Board.BoardDTO;
import marimo.harmonimo.dto.Board.BoardIdDTO;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping( produces = "application/json;charset=utf8")
public class BoardController {

    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @PostMapping("/boards")
    public ResponseEntity<BoardIdDTO> createBoard(@RequestBody BoardDTO boardDTO) {
        BoardIdDTO boardIdDTO = boardService.createBoard(boardDTO);
        return ResponseEntity.ok(boardIdDTO);
    }

    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<Boolean> deleteBoard(@PathVariable Long boardId) {
        boolean deleted = boardService.deleteBoard(boardId);
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<Boolean> updateBoard(
            @PathVariable Long boardId,
            @RequestBody BoardDTO updatedBoardDTO) {
        boolean updated = boardService.updateBoard(boardId, updatedBoardDTO);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardDTO>> getBoards() {
        List<BoardDTO> result = boardService.getBoards();
        return ResponseEntity.ok(result);
    }
}
