package marimo.harmonimo.controller;

import marimo.harmonimo.domain.MarimoData;
import marimo.harmonimo.dto.Log.LogDTO;
import marimo.harmonimo.dto.Log.LogSensorDTO;
import marimo.harmonimo.dto.MarimoData.MarimoDataSensorDTO;
import marimo.harmonimo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping( produces = "application/json;charset=utf8")
public class LogController {
    private final LogService logService;
    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/log/{stat}")
    public  ResponseEntity<Boolean> postSensorLog(@PathVariable String stat, @RequestBody LogSensorDTO logSensorDTO){
        if ("1".equals(stat)) {
            logService.save1(logSensorDTO);
        } else if ("2".equals(stat)) {
            logService.save2(logSensorDTO);
        } else if ("3".equals(stat)) {
            logService.save3(logSensorDTO);
        } else {
            // 잘못된 stat 값
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(true);
    }


    @GetMapping("/logs/{stat}")
    public ResponseEntity<List<LogDTO>> getLogDTOs(@PathVariable String stat) {
        List<LogDTO> result;
        if ("1".equals(stat)) {
            result = logService.getLogs1();
        } else if ("2".equals(stat)) {
            result = logService.getLogs2();
        } else if ("3".equals(stat)) {
            result = logService.getLogs3();
        } else {
            // 잘못된 stat 값
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(result);
    }



}
