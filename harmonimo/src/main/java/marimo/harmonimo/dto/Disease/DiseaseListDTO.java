package marimo.harmonimo.dto.Disease;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import marimo.harmonimo.domain.Disease;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class DiseaseListDTO {
    private List<Disease> diseases;

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
