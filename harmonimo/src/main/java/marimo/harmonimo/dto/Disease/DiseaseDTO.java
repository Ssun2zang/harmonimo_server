package marimo.harmonimo.dto.Disease;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import marimo.harmonimo.domain.Disease;

@Data
@NoArgsConstructor
@ToString
public class DiseaseDTO {
    private Long diseaseId;
    private String name;

    public static DiseaseDTO toDiseaseDTO(Disease disease){
        DiseaseDTO diseaseDTO = new DiseaseDTO();
        diseaseDTO.setDiseaseId(disease.getDiseaseId());
        diseaseDTO.setName(disease.getName());
        return diseaseDTO;
    }


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
