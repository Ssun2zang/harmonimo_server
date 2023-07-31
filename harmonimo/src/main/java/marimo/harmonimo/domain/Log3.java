package marimo.harmonimo.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "log3")
public class Log3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long logId;

    @ManyToOne
    @JoinColumn(name="marimoId")
    private Marimo marimo;

    @CreationTimestamp
    @Column
    private LocalDateTime timestamp;

}
