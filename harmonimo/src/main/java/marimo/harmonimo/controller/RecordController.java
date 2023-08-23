package marimo.harmonimo.controller;

import marimo.harmonimo.dto.Record.RecordDTO;
import marimo.harmonimo.dto.Record.RecordSendDTO;
import marimo.harmonimo.repository.RecordRepository;
import marimo.harmonimo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import marimo.harmonimo.domain.Record;

import java.util.List;

@Controller
@RestController
@RequestMapping( produces = "application/json;charset=utf8")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/records")
    public ResponseEntity<List<RecordDTO>> getRecords(){
        List<RecordDTO> records = recordService.getAllRecord();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/records/sender/{senderId}")
    public ResponseEntity<List<RecordDTO>> getRecordsBySender(@PathVariable String senderId){
        Long senderIdValue = Long.valueOf(senderId);
        List<RecordDTO> records = recordService.getAllRecordBySenderId(senderIdValue);
        return ResponseEntity.ok(records);
    }

    @GetMapping("/records/receiver/{receiverId}")
    public ResponseEntity<List<RecordDTO>> getRecordsByReceiver(@PathVariable String receiverId){
        Long receiverIdValue = Long.valueOf(receiverId);
        List<RecordDTO> records = recordService.getAllRecordByReceiverId(receiverIdValue);
        return ResponseEntity.ok(records);
    }

    @PostMapping("/records")
    public ResponseEntity<Boolean> sendRecord(@RequestBody RecordSendDTO recordSendDTO){
        recordService.save(recordSendDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }
}
