package marimo.harmonimo.dto.Log;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class UserLogDTO {
    private long marimoId;
    private LocalDateTime log1;
    private LocalDateTime log2;
    private LocalDateTime log3;

    public long getMarimoId() {
        return marimoId;
    }

    public void setMarimoId(long marimoId) {
        this.marimoId = marimoId;
    }

    public LocalDateTime getLog1() {
        return log1;
    }

    public void setLog1(LocalDateTime log1) {
        this.log1 = log1;
    }

    public LocalDateTime getLog2() {
        return log2;
    }

    public void setLog2(LocalDateTime log2) {
        this.log2 = log2;
    }

    public LocalDateTime getLog3() {
        return log3;
    }

    public void setLog3(LocalDateTime log3) {
        this.log3 = log3;
    }
}
