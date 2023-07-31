package marimo.harmonimo.dto.MarimoData;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
public class MarimoDataSensorDTO {
    private long marimoId;
    private int stat1;
    private int stat2;
    private int stat3;

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
}
