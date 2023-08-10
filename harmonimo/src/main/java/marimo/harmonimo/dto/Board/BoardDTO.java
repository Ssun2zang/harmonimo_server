package marimo.harmonimo.dto.Board;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import marimo.harmonimo.domain.Board;
import marimo.harmonimo.domain.MarimoData;
import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.MarimoData.MarimoDataSensorDTO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class BoardDTO {
    private long BoardId;
    private long userId;
    private String content;
    private String img;
    private LocalDateTime createTime;


    public static BoardDTO convertToDTO(Board board){
        BoardDTO dto = new BoardDTO();
        dto.setBoardId(board.getBoardId());
        dto.setUserId(board.getUser().getUserId());
        dto.setContent(board.getContent());
        dto.setImg(board.getImg());
        dto.setCreateTime(board.getCreateTime());
        return dto;
    }

    public long getBoardId() {
        return BoardId;
    }

    public void setBoardId(long boardId) {
        BoardId = boardId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
