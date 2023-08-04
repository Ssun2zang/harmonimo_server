package marimo.harmonimo.dto.Marimo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MarimoIdDTO {
    private Long marimoId;

    public Long getMarimoId() {
        return marimoId;
    }

    public void setMarimoId(Long marimoId) {
        this.marimoId = marimoId;
    }
}
