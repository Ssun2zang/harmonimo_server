package marimo.harmonimo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "log1")
public class Log1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long logId;

    @ManyToOne
    @JoinColumn(name="marimoId")
    private Marimo marimo;

    @Column
    private Timestamp timestamp;

}
