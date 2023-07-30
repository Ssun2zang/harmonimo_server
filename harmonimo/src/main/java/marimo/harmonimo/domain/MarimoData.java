package marimo.harmonimo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;

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

    @Column
    private Timestamp timestamp;
}
