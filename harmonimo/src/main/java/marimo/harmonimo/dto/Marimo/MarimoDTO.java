package marimo.harmonimo.dto.Marimo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import marimo.harmonimo.domain.Marimo;
@Data
@NoArgsConstructor
@ToString
public class MarimoDTO {
    private long marimoId;
    private String name;
    private long userId;
    private int deco1;
    private int deco2;
    private int deco3;
    private int emotion;

    public static MarimoDTO ToMarimoDTO(Marimo marimo){
        MarimoDTO marimoDTO = new MarimoDTO();
        marimoDTO.setMarimoId(marimo.getMarimoId());
        marimoDTO.setName(marimo.getName());
        marimoDTO.setUserId(marimo.getUser().getUserId());
        marimoDTO.setDeco1(marimo.getDeco1());
        marimoDTO.setDeco2(marimo.getDeco2());
        marimoDTO.setDeco3(marimo.getDeco3());
        marimoDTO.setEmotion(marimo.getEmotion());
        return marimoDTO;
    }

    public long getMarimoId() {
        return marimoId;
    }

    public void setMarimoId(long marimoId) {
        this.marimoId = marimoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getDeco1() {
        return deco1;
    }

    public void setDeco1(int deco1) {
        this.deco1 = deco1;
    }

    public int getDeco2() {
        return deco2;
    }

    public void setDeco2(int deco2) {
        this.deco2 = deco2;
    }

    public int getDeco3() {
        return deco3;
    }

    public void setDeco3(int deco3) {
        this.deco3 = deco3;
    }

    public int getEmotion() {
        return emotion;
    }

    public void setEmotion(int emotion) {
        this.emotion = emotion;
    }
}
