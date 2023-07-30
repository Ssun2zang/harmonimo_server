package marimo.harmonimo.dto.User;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Data
public class UserRegisterDTO extends UserDTO {
    private List<Long> diseases;
    private Long marimoId;

    public List<Long> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Long> diseases) {
        this.diseases = diseases;
    }
}
