package marimo.harmonimo.controller;

import marimo.harmonimo.domain.MarimoData;
import marimo.harmonimo.dto.MarimoData.MarimoDataSensorDTO;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserRegisterDTO;
import marimo.harmonimo.service.MarimoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping( produces = "application/json;charset=utf8")
public class MarimoDataController {
    private final MarimoDataService marimoDataService;
    @Autowired
    public MarimoDataController(MarimoDataService marimoDataService) {
        this.marimoDataService = marimoDataService;
    }

    @PostMapping("/marimoData/sensor")
    public  ResponseEntity<Boolean> postSensorData(@RequestBody MarimoDataSensorDTO marimoDataSensorDTO){
        marimoDataService.save(marimoDataSensorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @GetMapping("/marimoDatas")
    public ResponseEntity<List<MarimoData>> getMarimoDatas(@ModelAttribute MarimoData marimoData) {
        List<MarimoData> result = marimoDataService.getMarimoDatas();
        return ResponseEntity.ok(result);
    }
}
