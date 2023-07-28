package marimo.harmonimo.domain;

import javax.persistence.*;

public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diseaseId;
    private String name;

}
