package marimo.harmonimo.dto.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import marimo.harmonimo.domain.Disease;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Data
public class UserRegisterDTO extends UserDTO {
    private List<Long> diseases = new ArrayList<Long>();

    public void setDiseases(List<Long> diseases) {
        this.diseases = diseases;
    }
}
