package marimo.harmonimo.service;

import marimo.harmonimo.dto.Record.RecordDTO;
import marimo.harmonimo.dto.Record.RecordSendDTO;
import marimo.harmonimo.repository.RecordRepository;
import marimo.harmonimo.repository.UserRepository;
import org.springframework.stereotype.Service;
import marimo.harmonimo.domain.Record;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public RecordService(RecordRepository recordRepository, UserRepository userRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
    }
    
    public List<RecordDTO> getAllRecord(){
        List<Record> records = recordRepository.findAll();
        List<RecordDTO> dtos = records.stream()
                .map(Record::toRecordDTO)
                .collect(Collectors.toList());
        return dtos;
    }

    public void save(RecordSendDTO recordSendDTO){
        Record record = new Record();
        userRepository.findById(recordSendDTO.getSenderId())
                .ifPresent(user -> record.setSender(user));
        userRepository.findById(recordSendDTO.getReceiverId())
                .ifPresent(user -> record.setReceiver(user));
        record.setUrl(recordSendDTO.getUrl());
        recordRepository.save(record);
    }

    public List<RecordDTO> getAllRecordBySenderId(Long senderId){
        List<Record> records = recordRepository.findAllBySenderUserId(senderId);
        List<RecordDTO> dtos = records.stream()
                .map(Record::toRecordDTO)
                .collect(Collectors.toList());
        return dtos;
    }

    public List<RecordDTO> getAllRecordByReceiverId(Long receiverId){
        List<Record> records = recordRepository.findAllByReceiverUserId(receiverId);
        List<RecordDTO> dtos = records.stream()
                .map(Record::toRecordDTO)
                .collect(Collectors.toList());
        return dtos;
    }
}
