package marimo.harmonimo.dto.Log;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import marimo.harmonimo.domain.Log1;
import marimo.harmonimo.domain.Log2;
import marimo.harmonimo.domain.Log3;
import marimo.harmonimo.domain.Marimo;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class LogDTO {
    private long logId;
    private long mariomId;
    private LocalDateTime timestamp;

    public static LogDTO toLog1DTO(Log1 log1){
        LogDTO logDTO = new LogDTO();
        logDTO.setLogId(log1.getLogId());
        Marimo marimo = log1.getMarimo();
        if (marimo != null) {
            logDTO.setMariomId(marimo.getMarimoId());
        }
        logDTO.setTimestamp(log1.getTimestamp());
        return logDTO;
    }

    public static LogDTO toLog2DTO(Log2 log2){
        LogDTO logDTO = new LogDTO();
        logDTO.setLogId(log2.getLogId());
        Marimo marimo = log2.getMarimo();
        if (marimo != null) {
            logDTO.setMariomId(marimo.getMarimoId());
        }
        logDTO.setTimestamp(log2.getTimestamp());
        return logDTO;
    }

    public static LogDTO toLog3DTO(Log3 log3){
        LogDTO logDTO = new LogDTO();
        logDTO.setLogId(log3.getLogId());
        Marimo marimo = log3.getMarimo();
        if (marimo != null) {
            logDTO.setMariomId(marimo.getMarimoId());
        }
        logDTO.setTimestamp(log3.getTimestamp());
        return logDTO;
    }

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public long getMariomId() {
        return mariomId;
    }

    public void setMariomId(long mariomId) {
        this.mariomId = mariomId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
