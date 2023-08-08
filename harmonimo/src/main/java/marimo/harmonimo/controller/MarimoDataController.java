package marimo.harmonimo.controller;

import marimo.harmonimo.domain.MarimoData;
import marimo.harmonimo.dto.MarimoData.MarimoDataSensorDTO;
import marimo.harmonimo.dto.MarimoData.MarimoDataSensorTimeDTO;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserRegisterDTO;
import marimo.harmonimo.service.MarimoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<MarimoDataSensorTimeDTO>> getMarimoDatas() {
        List<MarimoData> marimoDataList = marimoDataService.getMarimoDatas();

        List<MarimoDataSensorTimeDTO> dtoList = new ArrayList<>();
        for (MarimoData marimoData : marimoDataList) {
            MarimoDataSensorTimeDTO dto = MarimoDataSensorTimeDTO.convertToDTO(marimoData);
            dtoList.add(dto);
        }

        return ResponseEntity.ok(dtoList);
    }


    @GetMapping("/marimoDatas/{userId}")
    public ResponseEntity<List<MarimoDataSensorDTO>> getUserMarimoDatas(@PathVariable String userId) {
        Long userIdValue = Long.valueOf(userId);
        List<MarimoData> marimoDataList = marimoDataService.getAllMarimoDataByUserId(userIdValue);

        List<MarimoDataSensorDTO> dtoList = new ArrayList<>();
        for (MarimoData marimoData : marimoDataList) {
            MarimoDataSensorDTO dto = MarimoDataSensorDTO.convertToDTO(marimoData);
            dtoList.add(dto);
        }

        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/marimoDatas/recent/{userId}")
    public ResponseEntity<MarimoDataSensorDTO> getUserMarimoRecentDatas(@PathVariable String userId) {
        Long userIdValue = Long.valueOf(userId);
        Optional<MarimoData> optionalMarimoData = marimoDataService.getMarimoDataByUserId(userIdValue);

        if (optionalMarimoData.isPresent()) {
            MarimoData marimoData = optionalMarimoData.get();
            MarimoDataSensorDTO dto = MarimoDataSensorDTO.convertToDTO(marimoData);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
