package marimo.harmonimo.dto.User;

import lombok.Data;

@Data
public class UserIdDTO {
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
