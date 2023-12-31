package marimo.harmonimo.controller;

import marimo.harmonimo.domain.Marimo;
import marimo.harmonimo.dto.Marimo.MarimoDTO;
import marimo.harmonimo.dto.Marimo.MarimoDecoEmotionDTO;
import marimo.harmonimo.dto.Marimo.MarimoIdDTO;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.service.MarimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping( produces = "application/json;charset=utf8")
public class MarimoController {
    private final MarimoService marimoService;

    public MarimoController(MarimoService marimoService) {
        this.marimoService = marimoService;
    }

    @GetMapping("/marimos/find/{accountId}")
    public ResponseEntity<MarimoIdDTO> findMarimoId(@PathVariable String accountId){
        Long marimoId = marimoService.findMarimoIdByName(accountId);
        MarimoIdDTO marimoIdDTO = new MarimoIdDTO();
        marimoIdDTO.setMarimoId(marimoId);
        return ResponseEntity.ok(marimoIdDTO);
    }

    @GetMapping("/marimo/{userId}")
    public ResponseEntity<MarimoDTO> getUserMarimo(@PathVariable String userId){
        Marimo marimo = marimoService.getUserMarimo(Long.valueOf(userId));
        MarimoDTO marimoDTO = MarimoDTO.ToMarimoDTO(marimo);
        return ResponseEntity.ok(marimoDTO);
    }

    @GetMapping("/marimos")
    public ResponseEntity<List<MarimoDTO>> getUsers() {
        List<MarimoDTO> result = marimoService.getALLMarimo();
        return ResponseEntity.ok(result);
    }

    @PutMapping("/marimo/{userId}")
    public ResponseEntity<Boolean> updateMarimo(
            @PathVariable long userId,
            @RequestBody MarimoDecoEmotionDTO updatedMarimo) {
        boolean updated = marimoService.updateMarimo(userId, updatedMarimo);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
