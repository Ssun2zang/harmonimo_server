package marimo.harmonimo.dto.User;

import lombok.Data;

import java.util.List;

@Data
public class UserRegisterDTO extends UserDTO {
    private List<Integer> diseases;

    public List<Integer> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Integer> diseases) {
        this.diseases = diseases;
    }
}
