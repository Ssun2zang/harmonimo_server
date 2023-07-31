package marimo.harmonimo.dto.User;

import lombok.Data;
import marimo.harmonimo.domain.Disease;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserRegisterDTO extends UserDTO {
    private List<Long> diseases = new ArrayList<Long>();

    public List<Long> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Long> diseases) {
        this.diseases = diseases;
    }
}
