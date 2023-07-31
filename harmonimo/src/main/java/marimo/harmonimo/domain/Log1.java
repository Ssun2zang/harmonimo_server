package marimo.harmonimo.domain;


import lombok.Getter;
import lombok.Setter;
import marimo.harmonimo.dto.Log.LogDTO;
import marimo.harmonimo.dto.User.UserDTO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDateTime;

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

    @CreationTimestamp
    @Column
    private LocalDateTime timestamp;


    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public Marimo getMarimo() {
        return marimo;
    }

    public void setMarimo(Marimo marimo) {
        this.marimo = marimo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
