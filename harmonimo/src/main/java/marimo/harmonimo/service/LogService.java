package marimo.harmonimo.service;

import marimo.harmonimo.domain.*;
import marimo.harmonimo.dto.Log.LogDTO;
import marimo.harmonimo.dto.Log.LogSensorDTO;
import marimo.harmonimo.dto.Log.UserLogDTO;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.repository.Log1Repository;
import marimo.harmonimo.repository.Log2Repository;
import marimo.harmonimo.repository.Log3Repository;
import marimo.harmonimo.repository.MarimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LogService {
    private final Log1Repository log1Repository;
    private final Log2Repository log2Repository;
    private final Log3Repository log3Repository;
    private final MarimoRepository marimoRepository;

    public LogService(Log1Repository log1Repository, Log2Repository log2Repository, Log3Repository log3Repository, MarimoRepository marimoRepository) {
        this.log1Repository = log1Repository;
        this.log2Repository = log2Repository;
        this.log3Repository = log3Repository;
        this.marimoRepository = marimoRepository;
    }

    public void save1(LogSensorDTO logSensorDTO){
        Log1 log1 = new Log1();
        marimoRepository.findById(logSensorDTO.getMarimoId())
                .ifPresent(marimo -> log1.setMarimo(marimo));
        log1Repository.save(log1);
    }

    public void save2(LogSensorDTO logSensorDTO){
        Log2 log2 = new Log2();
        marimoRepository.findById(logSensorDTO.getMarimoId())
                .ifPresent(marimo -> log2.setMarimo(marimo));
        log2Repository.save(log2);
    }

    public void save3(LogSensorDTO logSensorDTO){
        Log3 log3 = new Log3();
        marimoRepository.findById(logSensorDTO.getMarimoId())
                .ifPresent(marimo -> log3.setMarimo(marimo));
        log3Repository.save(log3);
    }

    public List<LogDTO> getLogs1() {
        List<Log1> logs = log1Repository.findAll();
        List<LogDTO> dtos = logs.stream()
                .map(LogDTO::toLog1DTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }

    public List<LogDTO> getLogs2() {
        List<Log2> logs = log2Repository.findAll();
        List<LogDTO> dtos = logs.stream()
                .map(LogDTO::toLog2DTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }

    public List<LogDTO> getLogs3() {
        List<Log3> logs = log3Repository.findAll();
        List<LogDTO> dtos = logs.stream()
                .map(LogDTO::toLog3DTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }

    public UserLogDTO getLatestLogByUserId(Long userId) {
        UserLogDTO dto = new UserLogDTO();

        Optional<Marimo> byUserId = marimoRepository.findByUserUserId(userId);
        byUserId.ifPresent(marimo -> dto.setMarimoId(marimo.getMarimoId()));

        Optional<Log1> latestLog1 = log1Repository.findTopByMarimoUserUserIdOrderByTimestampDesc(userId);
        latestLog1.ifPresent(log1 -> dto.setLog1(log1.getTimestamp()));

        Optional<Log2> latestLog2 = log2Repository.findTopByMarimoUserUserIdOrderByTimestampDesc(userId);
        latestLog2.ifPresent(log2 -> dto.setLog2(log2.getTimestamp()));

        Optional<Log3> latestLog3 = log3Repository.findTopByMarimoUserUserIdOrderByTimestampDesc(userId);
        latestLog3.ifPresent(log3 -> dto.setLog3(log3.getTimestamp()));
        return dto;
    }

    public List<LogDTO> getLogs1ByUserId(Long userId){
        List<Log1> logs = log1Repository.findLog1ByMarimoUserUserId(userId);
        List<LogDTO> dtos = logs.stream()
                .map(LogDTO::toLog1DTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }

    public List<LogDTO> getLogs2ByUserId(Long userId){
        List<Log2> logs = log2Repository.findLog2ByMarimoUserUserId(userId);
        List<LogDTO> dtos = logs.stream()
                .map(LogDTO::toLog2DTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }

    public List<LogDTO> getLogs3ByUserId(Long userId){
        List<Log3> logs = log3Repository.findLog3ByMarimoUserUserId(userId);
        List<LogDTO> dtos = logs.stream()
                .map(LogDTO::toLog3DTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }

}
