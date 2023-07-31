package marimo.harmonimo.dto.Log;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LogSensorDTO {
    private long marimoId;

    public long getMarimoId() {
        return marimoId;
    }

    public void setMarimoId(long marimoId) {
        this.marimoId = marimoId;
    }
}
