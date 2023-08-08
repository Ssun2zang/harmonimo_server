package marimo.harmonimo.dto.MarimoData;

import lombok.*;
import marimo.harmonimo.domain.MarimoData;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class MarimoDataSensorTimeDTO {
    private long marimoId;
    private int stat1;
    private int stat2;
    private int stat3;

    private LocalDateTime timestamp;

    public static MarimoDataSensorTimeDTO convertToDTO(MarimoData marimoData) {
        MarimoDataSensorTimeDTO dto = new MarimoDataSensorTimeDTO();
        if (marimoData.getMarimo() != null) {
            dto.setMarimoId(marimoData.getMarimo().getMarimoId());
        }
        dto.setStat1((int) marimoData.getStat1());
        dto.setStat2((int) marimoData.getStat2());
        dto.setStat3((int) marimoData.getStat3());
        dto.setTimestamp(marimoData.getTimestamp());
        return dto;
    }



    public long getMarimoId() {
        return marimoId;
    }

    public void setMarimoId(long marimoId) {
        this.marimoId = marimoId;
    }

    public int getStat1() {
        return stat1;
    }

    public void setStat1(int stat1) {
        this.stat1 = stat1;
    }

    public int getStat2() {
        return stat2;
    }

    public void setStat2(int stat2) {
        this.stat2 = stat2;
    }

    public int getStat3() {
        return stat3;
    }

    public void setStat3(int stat3) {
        this.stat3 = stat3;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
