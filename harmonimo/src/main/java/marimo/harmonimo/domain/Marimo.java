package marimo.harmonimo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "marimos")
public class Marimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long marimoId;

    @Column
    private String name;

    @Column
    private long userId;

    @Column
    private int deco1;

    @Column
    private int deco2;

    @Column
    private int deco3;

    @Column
    private int emotion;


}
