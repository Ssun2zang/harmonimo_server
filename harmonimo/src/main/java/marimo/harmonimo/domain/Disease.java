package marimo.harmonimo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diseases")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diseaseId")
    private Long diseaseId;

    @Column(name = "name")
    private String name;

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

