package marimo.harmonimo.dto.Board;

import lombok.Data;

@Data
public class BoardIdDTO {
    private long BoardId;

    public long getBoardId() {
        return BoardId;
    }

    public void setBoardId(long boardId) {
        BoardId = boardId;
    }
}
