package marimo.harmonimo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "log3")
public class Log3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long logId;

    @Column
    private long marimoId;

    @Column
    private Timestamp timestamp;

}
