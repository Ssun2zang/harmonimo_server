package marimo.harmonimo.dto.Marimo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MarimoDecoEmotionDTO {
    private int deco1;
    private int deco2;
    private int deco3;
    private int emotion;


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
