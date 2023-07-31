package marimo.harmonimo.controller;
import marimo.harmonimo.domain.Disease;
import marimo.harmonimo.domain.DiseaseUser;
import marimo.harmonimo.dto.Disease.DiseaseDTO;
import marimo.harmonimo.dto.Disease.DiseaseListDTO;
import marimo.harmonimo.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RestController
@RequestMapping( produces = "application/json;charset=utf8")
public class DiseaseController {
    private final DiseaseService diseaseService;
    @Autowired
    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping("/diseases")
    public ResponseEntity<DiseaseListDTO> GetDiseases() {
        List<Disease> _diseases = diseaseService.GetDiseases();
        DiseaseListDTO diseases = new DiseaseListDTO();
        diseases.setDiseases(_diseases);
        return ResponseEntity.status(HttpStatus.OK).body(diseases);
    }

    @GetMapping("/diseaseUser")
    public ResponseEntity<List<DiseaseUser>> GetDiseaseUsers() {
        List<DiseaseUser> _diseaseUsers = diseaseService.GetDiseaseUsers();
        return ResponseEntity.status(HttpStatus.OK).body(_diseaseUsers);
    }
}
