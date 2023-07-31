package marimo.harmonimo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "marimos")
public class Marimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long marimoId;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name="userId")
    private User user;

    @Column
    private int deco1;

    @Column
    private int deco2;

    @Column
    private int deco3;

    @Column
    private int emotion;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
