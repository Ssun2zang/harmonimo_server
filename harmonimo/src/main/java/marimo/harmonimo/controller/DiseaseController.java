package marimo.harmonimo.controller;
import marimo.harmonimo.domain.Disease;
import marimo.harmonimo.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RestController
public class DiseaseController {
    private final DiseaseService diseaseService;
    @Autowired
    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping("/diseases")
    public ResponseEntity<List<Disease>> GetDiseases() {
        List<Disease> diseases = diseaseService.GetDiseases();
        return ResponseEntity.status(HttpStatus.OK).body(diseases);
    }
}
