package marimo.harmonimo.dto.User;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserLoginDTO {
    private String accountId;
    private String password;
}
