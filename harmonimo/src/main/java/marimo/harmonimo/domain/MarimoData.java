package marimo.harmonimo.domain;

import lombok.Getter;
import lombok.Setter;
import marimo.harmonimo.dto.MarimoData.MarimoDataSensorDTO;
import marimo.harmonimo.dto.User.UserDTO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "marimo_data")
public class MarimoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long dataId;

    @ManyToOne
    @JoinColumn(name="marimoId")
    private Marimo marimo;

    @Column
    private long stat1;

    @Column
    private long stat2;

    @Column
    private long stat3;

    @CreationTimestamp
    @Column
    private LocalDateTime timestamp;


    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    public Marimo getMarimo() {
        return marimo;
    }

    public void setMarimo(Marimo marimo) {
        this.marimo = marimo;
    }

    public long getStat1() {
        return stat1;
    }

    public void setStat1(long stat1) {
        this.stat1 = stat1;
    }

    public long getStat2() {
        return stat2;
    }

    public void setStat2(long stat2) {
        this.stat2 = stat2;
    }

    public long getStat3() {
        return stat3;
    }

    public void setStat3(long stat3) {
        this.stat3 = stat3;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
